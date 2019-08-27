package com;

import com.fw.web.MvcFramework;

public class App {
	
	public static void main(String[] args) {
		
		
		MvcFramework framework=new MvcFramework();
		framework.handleRequest("/users/login");
		
	}

}
