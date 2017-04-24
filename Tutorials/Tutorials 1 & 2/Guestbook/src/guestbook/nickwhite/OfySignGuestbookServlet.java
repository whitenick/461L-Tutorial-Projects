//https://1-dot-guestbook-156720.appspot.com/ofyguestbook.jsp

package guestbook.nickwhite;

 
import static com.googlecode.objectify.ObjectifyService.ofy;

import com.google.appengine.api.datastore.Entity;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import com.google.appengine.api.users.User;

import com.google.appengine.api.users.UserService;

import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;
	

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

public class OfySignGuestbookServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)

                throws IOException {

        UserService userService = UserServiceFactory.getUserService();

        User user = userService.getCurrentUser();

 

        // We have one entity group per Guestbook with all Greetings residing

        // in the same entity group as the Guestbook to which they belong.

        // This lets us run a transactional ancestor query to retrieve all

        // Greetings for a given Guestbook.  However, the write rate to each

        // Guestbook should be limited to ~1/second.

        String guestbookName = req.getParameter("guestbookName");

        Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);

        String content = req.getParameter("content");

        Date date = new Date();

        Entity greeting = new Entity("Greeting", guestbookKey);
        
        
        //Objectify code setup
       // Greeting greet = ObjectifyService.ofy().load().key(guestbookKey).get();
        
        
        
        
        greeting.setProperty("user", user);

        greeting.setProperty("date", date);

        greeting.setProperty("content", content);
        
        
        //OBJECTIFY
        
        Greeting newGreeting = new Greeting(user, content);
        
        
        ObjectifyService.register(Greeting.class);

        //List<Greeting> greetings = ObjectifyService.ofy().load().type(Greeting.class).list();   

        //Collections.sort(greetings); 
        
        ofy().save().entity(newGreeting).now();
        resp.sendRedirect("/ofyguestbook.jsp?guestbookName=" + guestbookName);

    }

}