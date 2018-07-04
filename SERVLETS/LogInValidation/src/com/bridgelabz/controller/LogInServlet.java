package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DataAccessObject;
import com.bridgelabz.listener.MyHttpSessionListener;
import com.bridgelabz.model.UserBean;

/**
 * @author yuga
 *
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = -7696017094585463102L;

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccessObject object = new DataAccessObject();
		UserBean bean = new UserBean();

		ServletContext context = req.getServletContext();
		MyHttpSessionListener.totalUserVisited++;
		context.setAttribute("totalUserVisited", MyHttpSessionListener.totalUserVisited);

		HttpSession session = session = req.getSession(true);
		session.setMaxInactiveInterval(60);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		bean.setEmail(username);
		bean.setPassword(password);

		String select = "select * from Students where Email = ? and Password = ?";

		object.connectionPoolFactory();
		try {
			object.pst = object.con.prepareStatement(select);
			object.pst.setString(1, username);
			object.pst.setString(2, password);
			object.res = object.pst.executeQuery();

			if (object.res.next()) {
				int serialNum = object.res.getInt(1);
				String fullName = object.res.getString(2);
				long mobile = object.res.getLong(3);
				session.setAttribute("message", "you are successfully login");
				session.setAttribute("serialNum", serialNum);
				session.setAttribute("fullName", fullName);
				session.setAttribute("mobile", mobile);
				session.setAttribute("username", username);

				// System.out.println("activeUsers : " + activeUser);

				resp.sendRedirect("SuccessFullLogIn");

			} else {
				System.out.println("Not Valid user");
				resp.sendRedirect("UnsuccessfulLogIn");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
