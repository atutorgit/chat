package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.tutornet.struts.model.db.UserDAOImpl;
import fr.tutornet.struts.model.javabeans.User;

public class LoginUser extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = "undefined";

		UserForm userForm = (UserForm) form;

		UserDAOImpl dao = new UserDAOImpl();
		User userFromDB = dao.findUser(userForm.getUser().getLogin());

		if (userForm.getUser().getPassword().equals(userFromDB.getPassword())) {
			userForm.setUser(userFromDB);
			result = "success";
		} else {
			response.getWriter().println(
					"<strong>Wrong password for this login!</strong><br>");
		}

		// Looks like this has no effects
		// if there is a forward match in struts-config.xml (result="success")
		request.getRequestDispatcher("/login.jsp").include(request,
				response);

		return mapping.findForward(result);
	}

}
