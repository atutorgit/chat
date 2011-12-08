package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.tutornet.struts.model.javabeans.Chat;

public class ChatManagement extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String connectedUserLogin = ((UserForm) request.getSession()
				.getAttribute("userActionForm")).getUser().getLogin();

		String message = request.getParameter("message");

		Chat chat = Chat.getInstance();

		chat.setMessages(connectedUserLogin + ": " + message + "\n"
				+ chat.getMessages());

		request.setAttribute("chat", chat);

		return mapping.findForward("success");
	}

}
