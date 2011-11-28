package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class PasswordForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm;

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

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors result = new ActionErrors();

		if (oldPassword == null || oldPassword.length() < 1) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.oldPassword"));
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
}
