package com.cugb.javaee.action;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.swing.JOptionPane;

public class UserSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "登陆成功", "注意", 
        		JOptionPane.ERROR_MESSAGE);   
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "注销成功", "注意", 
        		JOptionPane.ERROR_MESSAGE);   
	}

}
