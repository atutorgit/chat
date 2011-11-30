package fr.tutornet.struts.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import fr.tutornet.struts.UserForm;
import fr.tutornet.struts.model.db.UserDAOImpl;
import fr.tutornet.struts.model.javabeans.User;

public class UpdateSession implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestHttp = (HttpServletRequest) request;

		UserDAOImpl dao = new UserDAOImpl();

		String connectedUserLogin = ((UserForm) requestHttp.getSession()
				.getAttribute("userActionForm")).getUser().getLogin();

		User userFromDB = dao.findUser(connectedUserLogin);

		UserForm newActionForm = new UserForm();
		newActionForm.setUser(userFromDB);

		requestHttp.getSession().setAttribute("userActionForm", newActionForm);
		
		chain.doFilter(requestHttp, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
