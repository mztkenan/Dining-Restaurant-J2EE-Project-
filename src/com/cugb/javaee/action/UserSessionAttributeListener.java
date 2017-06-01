package com.cugb.javaee.action;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.swing.JOptionPane;

public class UserSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		JOptionPane.showMessageDialog(null, "用户登陆成功", "注意", 
=======
		JOptionPane.showMessageDialog(null, "操作成功", "注意", 
>>>>>>> 94078df663320d13947bca9b88bfd9524e81b7d4
        		JOptionPane.ERROR_MESSAGE);   
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		JOptionPane.showMessageDialog(null, "用户注销成功", "注意", 
=======
		JOptionPane.showMessageDialog(null, "操作成功", "注意", 
>>>>>>> 94078df663320d13947bca9b88bfd9524e81b7d4
        		JOptionPane.ERROR_MESSAGE);   
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
