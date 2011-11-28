package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.tutornet.struts.model.javabeans.User;

public class UserForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors result = new ActionErrors();

		if (user.getLogin() == null || user.getLogin().length() < 1) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.login"));
		}
		if (user.getPassword() == null || user.getPassword().length() < 1) {
			result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.password"));
		}
		return result;
	}
}
