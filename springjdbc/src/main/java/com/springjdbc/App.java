package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employee e = new Employee();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springjdbc/config1.xml");
        EmployeeDao dao = (EmployeeDao)ctx.getBean("edao");
        int status1 = dao.saveEmployee(new Employee(141,"Raman Aggarwal",65000));
        System.out.println("Record Inserted"+" "+status1);
        
    }
}
