package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.tutornet.struts.model.javabeans.User;

public class PasswordForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userLogin;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm;
	private boolean userAdmin;

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}

	public boolean isUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(boolean userAdmin) {
		this.userAdmin = userAdmin;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors result = new ActionErrors();
		
		if (userLogin == null || userLogin.length() < 1) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.userLogin"));
		}

		if (oldPassword == null || oldPassword.length() < 1) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.oldPassword"));
		}

		// Retrieve User object from session
		UserForm uf = (UserForm) request.getSession().getAttribute(
				"userActionForm");
		User connectedUser = uf.getUser();

		// Admin doesn't need confirmation
		if (connectedUser.isAdmin()) {
			setNewPasswordConfirm(getNewPassword());
		}

		if ((newPassword == null || newPassword.length() < 1)
				|| (newPasswordConfirm == null || newPasswordConfirm.length() < 1)) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.newPassword"));
		} else if (!newPasswordConfirm.equals(newPassword)) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.newPasswordConfirm"));
		}

		return result;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// When using checkbox fields, they have to be resetted for proper use
		setUserAdmin(false);
	}
	
}
