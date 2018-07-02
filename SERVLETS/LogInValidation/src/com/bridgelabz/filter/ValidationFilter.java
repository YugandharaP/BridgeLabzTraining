package com.bridgelabz.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DataAccessObject;
import com.bridgelabz.model.UserBean;

/**
 * Servlet Filter implementation class ValidationFilter
 */
// @WebFilter("/ValidationFilter")
public class ValidationFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("enterd into filter");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		DataAccessObject object = new DataAccessObject();
		object.connectionPoolFactory();
		String email = request.getParameter("email");
		System.out.println(email);
		String query = "select * from Students where Email = ?";

		try {
			object.pst=object.con.prepareStatement(query);
			object.pst.setString(1, email);
			object.res = object.pst.executeQuery();
			if (object.res.next()) {
				/*Cookie cookie = new Cookie("message", "Email allready present in database. ReSignUp");
				resp.addCookie(cookie);*/
				HttpSession session = req.getSession(true);
				session.setAttribute("message", "Email allready present in database. ReSignUp");
				resp.sendRedirect("UnsuccessFullRegister");
				System.out.println("after vcvht");

			} else {
				chain.doFilter(request, response);
				System.out.println("f76rtfutg7y");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
