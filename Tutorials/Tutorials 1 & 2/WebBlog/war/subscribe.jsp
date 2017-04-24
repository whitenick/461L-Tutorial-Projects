<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.nickwhite.WebBlog.*" %>

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
	
	<form name="myForm" class="w3-center" action="/subscribe" method="post">
		<p>Enter your email to subscribe to updates or unsubscribe.</p>
		<div><textarea name="email" rows="1" cols="60"></textarea></div>
		<input type="submit" value="Submit"/>
	</form>
 

  </body>

</html>