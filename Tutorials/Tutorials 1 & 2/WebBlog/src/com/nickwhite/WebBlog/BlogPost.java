package com.nickwhite.WebBlog;

import java.util.Date;

import com.googlecode.objectify.ObjectifyService;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class BlogPost implements Comparable<BlogPost> {

	static { ObjectifyService.register(BlogPost.class); }
	
	@Id Long id;
	
	User user;
	String content;
	Date date;
	String title;
	
	
	
	private BlogPost() {}
	
	public BlogPost(User user, String content, String title) {
		this.user = user;
		
		this.content = content;
		
		this.title = title;
		
		date = new Date();
	}
	
	public User getUser() {
		
		return user;
		
	}
	
	public String getContent() {
		
		return content; 
		
	}
	
	public String getTitle() {
		return title;
	}
	
	
	@Override
	
	public int compareTo(BlogPost other) {
		
		if (date.after(other.date)) {

            return -1;

        } else if (date.before(other.date)) {

            return 1;

        }

        return 0;
	}
}
