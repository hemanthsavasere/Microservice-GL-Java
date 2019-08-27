package com.fw.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.app.web.UserController;

public class MvcFramework {

	public void handleRequest(String url) {

		Class clazz = null;
		Object instance = null;
		try {
			clazz = Class.forName("com.app.web.UserController");
			instance = clazz.newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			RequestMapping rm = method.getAnnotation(RequestMapping.class);
			if (rm != null) {
				String givenUrl = rm.value();
				RequestMethod httpMethod = rm.method();
				if (givenUrl.equals(url)) {
					try {
						method.invoke(instance, new Object[] { "user1", "shhhh" });
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
