package com.app.web;

import com.fw.web.RequestMapping;
import com.fw.web.RequestMethod;


public class UserController {

	@RequestMapping(value = "/users/login",method = RequestMethod.POST)
	public void doLogin(String userName,String password) {
		System.out.println("UserController :: doLogin - "+userName+"\t"+password);
	}

	@RequestMapping(value = "/users/register",method = RequestMethod.POST)
	public void doRegister() {
		System.out.println("UserController :: doRegister");
	}

}
