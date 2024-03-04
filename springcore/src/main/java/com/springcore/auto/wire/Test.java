package com.springcore.auto.wire;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-genewrated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/auto/wire/config.xml");
		Emp emp1 = context.getBean("emp1", Emp.class);
		System.out.println(emp1);
	}

}
