package fr.tutornet.struts;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.tutornet.struts.model.db.UserDAOImpl;
import fr.tutornet.struts.model.javabeans.User;

public class ViewOthers extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserDAOImpl dao = new UserDAOImpl();
		Collection<User> users = dao.allUsers();

		request.setAttribute("users", users);

		return mapping.findForward("success");
	}

}
