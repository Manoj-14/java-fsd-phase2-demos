package com.project.listiners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyListener implements HttpSessionListener, HttpSessionAttributeListener {

    public MyListener() {
        
    }


    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Hello from listiner session is crated at "+new Date(se.getSession().getCreationTime()));
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session destroyed");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
         System.out.println("From listener key of name "+se.getName() +" and value "+se.getValue()+" is added.....");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("From listener key of name "+se.getName() +" and value "+se.getValue()+" is removed.....");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("From listener key of name "+se.getName() +" and value "+se.getValue()+" is modified....."); 
    }
	
}
