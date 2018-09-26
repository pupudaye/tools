package org.pl.sports.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launcher {
	
	public static void launch() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
}
