<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>

<%@ page import="java.util.Collections" %>

<%@ page import="com.nickwhite.WebBlog.*" %>

<%@ page import="com.googlecode.objectify.ObjectifyService" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


 

<html>

<link rel="stylesheet" href="/stylesheets/w3.css" type="text/css">
<link rel="stylesheet" href="/stylesheets/main.css" type="text/css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <head>

  </head>

 

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
	ObjectifyService.register(BlogPost.class);
	List<BlogPost> posts = ObjectifyService.ofy().load().type(BlogPost.class).list();   
	Collections.sort(posts); 
    if (posts.isEmpty()) {
        %>

        <p class="w3-center">No posts have been written.</p>

        <%
    } else {
        %>

        <p class="w3-center">Posts on the website are as follows: </p>

        <%
        for (BlogPost post : posts) {
            pageContext.setAttribute("post_user", post.getUser());
            
            pageContext.setAttribute("post_title", post.getTitle());
            
            pageContext.setAttribute("post_content", post.getContent());
            %>

            <p class="w3-center"><b>${fn:escapeXml(post_title)}</b></p>

            <%
            
            %>

            <p class="w3-center">${fn:escapeXml(post_content)}</p>

            <%
            
            %>

            <p class="w3-center">Posted by: ${fn:escapeXml(post_user.nickname)}</p>

            <%
    	}
    }
%>

  </body>

</html>