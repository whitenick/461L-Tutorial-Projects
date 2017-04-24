package com.nickwhite.WebBlog;

import java.io.IOException;

import com.google.appengine.api.users.User;

import com.google.appengine.api.users.UserService;

import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;


import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class WebBlogServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		
		User user = userService.getCurrentUser();
		
		
		
		
		
		String content = req.getParameter("content");
		
		String title = req.getParameter("title");
		
		
		BlogPost newPost = new BlogPost(user, content, title);
		
		ObjectifyService.register(BlogPost.class);
		
		ObjectifyService.ofy().save().entity(newPost).now();
		
		resp.sendRedirect("/ofywebblog.jsp");
		
		
		
	}
}
