package com.bridgelabz.listener;

import java.sql.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{
	int totalSessionCount = 0;
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		HttpSession session =httpSessionEvent.getSession();
		Date createTime = new Date(session.getCreationTime());
		totalSessionCount++;
		System.out.println("Session Created at : "+session.getCreationTime()+" with id : "+session.getId()+"createTime: "+createTime);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		HttpSession session =httpSessionEvent.getSession();
		System.out.println("session Destroyed with id : "+session.getId());
		System.out.println("totalSessionCount : "+totalSessionCount);
	}

}
