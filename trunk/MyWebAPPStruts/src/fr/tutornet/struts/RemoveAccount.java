package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.tutornet.struts.model.db.UserDAOImpl;

/**
 * We want to avoid to create an ActionForm for this Action
 * 
 * @author root
 * 
 */
public class RemoveAccount extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String loginUserToDelete = null;

		if (request.getParameter("userLogin") != null
				&& request.getParameter("userLogin").length() >= 1)
		{ // From viewOthers.jsp
			loginUserToDelete = request.getParameter("userLogin");
		} else
		{ // From operations.jsp
			loginUserToDelete = ((UserForm) request.getSession().getAttribute(
					"userActionForm")).getUser().getLogin();
		}

		UserDAOImpl dao = new UserDAOImpl();
		dao.deleteUser(dao.findUser(loginUserToDelete));

		return mapping.findForward("success");
	}
}
