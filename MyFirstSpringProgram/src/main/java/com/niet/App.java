package com.niet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {// for setter injection
        //System.out.println( "Hello World!" );
    	ApplicationContext context=new ClassPathXmlApplicationContext("com/niet/Config.xml");
    	Student student1=(Student)context.getBean("objStudent",Student.class);
    	System.out.println(student1);
    }
}
