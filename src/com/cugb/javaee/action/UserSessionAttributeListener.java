package com.cugb.javaee.action;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.swing.JOptionPane;

public class UserSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "User登陆成功", "注意", 
        		JOptionPane.ERROR_MESSAGE);   
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "User注销成功", "注意", 
        		JOptionPane.ERROR_MESSAGE);   
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
