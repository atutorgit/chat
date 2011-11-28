package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.tutornet.struts.model.db.UserDAOImpl;
import fr.tutornet.struts.model.javabeans.User;

public class EditPassword extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = "undefined";

		PasswordForm passwordForm = (PasswordForm) form;

		// Retrieve User login from session
		UserForm uf = (UserForm) request.getSession().getAttribute(
				"userActionForm");
		String userLogin = uf.getUser().getLogin();

		UserDAOImpl dao = new UserDAOImpl();

		// Retrieve User from DB
		User userFromDB = dao.findUser(userLogin);

		if (userFromDB.getPassword().equals(passwordForm.getOldPassword())) {
			userFromDB.setPassword(passwordForm.getNewPassword());
			if (dao.updateUser(userFromDB)) {
				result = "success";
			} else {
				response.getWriter().println(
						"<strong>Database issue!</strong><br>");
			}
		} else {
			response.getWriter()
					.println("<strong>Wrong current password!</strong><br>");
		}
		// Looks like this has no effects
		// if there is a forward match in struts-config.xml (result="success")
		request.getRequestDispatcher("/editPassword.jsp").include(request,
				response);

		return mapping.findForward(result);
	}

}
