package springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    
    
	@RequestMapping(value = "/")
    public String home() {
        System.out.println("this is home");
        return "index";// Assuming "home" is the name of your view/template
    }
    @RequestMapping(value = "/about")
    public String about() {
        System.out.println("this is about");
        return "about"; // Assuming "home" is the name of your view/template
        
        
        //WHY MVC??
        // mvc - use model view controller.
        // spring mvc- subframework of Spring.
        // mvc- buil on servlet API
        //if every code in servlet - not follow mvc? F**k..
        //spring core concept used here - autowire / injection/inversion control
        // powerful configuration
        // IOC container here make it better.
        
        
        // mvc-> design-pattern.
        // mvc - easy to scale and maintain.
        // servlet -- logic / controller.
        // jsp -  view.
        // pojo/bean- model using DAO.
        
        // how spring-mvc works?
        // let a server may be tomcat now if client req it goes to frontcontroller/dispatcherservlet.
        // then frontcontroller transfer to controller then it work and go to frontcontr.
        //now view and model come to frontcontr then data from model fit to view and 
        //view page shown to data
        
        //step for mvc
      
        // create dispacher servlet in web.xml -- servlet mapping
        // create spring config file -- define bean
        // create view resolver in 2
        // create controller  
        // create view to
        
        
    }
    
}