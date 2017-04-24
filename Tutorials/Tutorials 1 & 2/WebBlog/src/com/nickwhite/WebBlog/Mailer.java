package com.nickwhite.WebBlog;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;

import com.googlecode.objectify.ObjectifyService;  
  
public class Mailer {  
	
	@SuppressWarnings("deprecation")
	public static void send(){ 
	
		ObjectifyService.register(BlogPost.class);
	
		List<BlogPost> posts = ObjectifyService.ofy().load().type(BlogPost.class).list();   
	
		Collections.sort(posts); 
		
		Date current = new Date();
		
		current.setDate(current.getDate() - 1);
		
		for (BlogPost post : posts){
			if (post.date.before(current)){
				posts.remove(post);
			}
		}
		
		if (posts.isEmpty()){
			return;
		}
		
		ObjectifyService.register(Email.class);
	
		List<Email> subscribers = ObjectifyService.ofy().load().type(Email.class).list();
		  
		//1st step) Get the session object    
		Properties props = new Properties();  
		props.put("mail.smtp.host", "mail.javatpoint.com");//change accordingly  
		props.put("mail.smtp.auth", "true");  
		  
		Session session = Session.getDefaultInstance(props);
		
		
		//2nd step: compose message  
		try {  
			
			String subject = "Daily updates from LONGHORN FANATICS blog";	
			
			MimeMessage message = new MimeMessage(session);  
			
			message.setFrom(new InternetAddress("nw.white22@gmail.com"));  
			
			for (Email subscriber : subscribers){
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(subscriber.getEmail()));  
			}
			
			message.setSubject(subject);		
			
			
			String body = "";
			
			for (BlogPost post : posts){
				body.concat("<p><img src=\"" + post.getContent() + "\" alt = \"Not found\"></p>");
			}
			
			
			String header = "<html><body><p>Check longhornfanatics.appspot.com to see new updates!</p>" + body + 
							"<p>Or, you can unsubscribe <a href = longhornfanatics.appspot.com/subscribe.jsp >here</a></p></body></html>";
			
			message.setContent(header, "text/html");  
		   
			//3rd step: send message 
			
			Transport.send(message);  
			  
		 } catch (Exception e) {  
		    throw new RuntimeException(e);  
		 }      
	}  
}  
