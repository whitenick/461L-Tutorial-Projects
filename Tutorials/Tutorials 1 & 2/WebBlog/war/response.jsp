<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>

<%@ page import="java.util.Collections" %>

<%@ page import="com.nickwhite.WebBlog.*" %>

<%@ page import= "com.googlecode.objectify.ObjectifyService" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>

<%@ page import="com.google.appengine.api.datastore.Query" %>

<%@ page import="com.google.appengine.api.datastore.Entity" %>

<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>

<%@ page import="com.google.appengine.api.datastore.Key" %>

<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<html xmlns="http://www.w3.org/1999/xhtml" lang="en">


	<link rel="stylesheet" href="/stylesheets/w3.css" type="text/css">
	<link rel="stylesheet" href="/stylesheets/main.css" type="text/css">

	
	
	
	<body>
	
	<!-- !HEADER! -->
	<header class="w3-panel w3-center">
  		<!-- !MENU! -->
		<ul class="w3-navbar w3-black">
  			<li style="width:20%"><a href="ofywebblog.jsp">Home</a></li>
  			<li style="width:20%"><a href="allposts.jsp">All Posts</a></li>
  			<li style="width:20%"><a href="response.jsp">Write Post</a></li>
  			<li style="width:20%"><a href="subscribe.jsp">Subscribe</a></li>
  			<li style="width:20%"><a href="about.html">About</a></li>
		</ul>
  		<h1 class="w3-center">LONGHORN FANATICS</h1> 				
	</header>
	
	<%
		UserService userService = UserServiceFactory.getUserService();
	
		User user = userService.getCurrentUser();
		
		if(user != null) {
			pageContext.setAttribute("user", user);
		
	%>
	
	<p class="w3-center">Hello, ${fn:escapeXml(user.nickname)}! You can post below. Please do not leave submission boxes blank.</p>
	
	<form action="/ofypost" method="post">
		<p>Give your post a title. </p>
		<div><textarea name="title" rows="3" cols="60"></textarea></div>
		<p>Write your blog post below:</p> 
		<div><textarea name="content" rows="3" cols="60"></textarea></div>
		<div><input type="submit" value="Post Message" /></div>
	</form>
		
	<%
		} else {
	%>
	
	<p class="w3-center">You must <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">sign in</a> to post.</p>
	
	<%
		}
	%>
	</body>
	
</html>