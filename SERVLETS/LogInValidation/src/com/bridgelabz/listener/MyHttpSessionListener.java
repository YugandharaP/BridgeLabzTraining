package com.bridgelabz.listener;

import java.sql.Date;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	 int activeUser = 0;
	 public static int totalUserVisited = 0;

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		
		HttpSession session = httpSessionEvent.getSession();
		Date createTime = new Date(session.getCreationTime());
	
		activeUser++;
		System.out.println("Session Created  with id : " + session.getId() + " time : " + session.getCreationTime()
				+ " createTime: " + createTime);
		System.out.println("activeUsers : " + activeUser);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		ServletContext context = httpSessionEvent.getSession().getServletContext();
		HttpSession session = httpSessionEvent.getSession();
		if (activeUser > 0)
			activeUser--;
		System.out.println("session Destroyed with id : " + session.getId());
		System.out.println("totalUserVisited : " +context.getAttribute("totalUserVisited") );
		System.out.println("activeUsers : " + activeUser);

		System.out.println("-------------------------------------------------------------------------");

	}

}
