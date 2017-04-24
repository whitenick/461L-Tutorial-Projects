package com.nickwhite.WebBlog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;  
  
  
@SuppressWarnings("serial")
public class SubscriptionServlet extends HttpServlet {  
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {           
		Mailer.send();  
    }  
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		ObjectifyService.register(Email.class);
		
		Email email = new Email(req.getParameter("email"));
		
		List<Email> subscribers = ObjectifyService.ofy().load().type(Email.class).list();
		
		boolean unsubscribe = false;
		
		for (Email subscriber : subscribers){
			
			if(subscriber.getEmail().equals(email.getEmail())){
				
				ObjectifyService.ofy().delete().entity(subscriber).now();
				
				unsubscribe = true;
			}
		}
		
		if (!unsubscribe){
			
			ObjectifyService.ofy().save().entity(email).now();
		}
		
	    resp.sendRedirect("/subscriptionSuccess.html");
	}
  
}