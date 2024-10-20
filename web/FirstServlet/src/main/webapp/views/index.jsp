<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Servlet</title>
</head>
<h1>Welcome to HSw's Servlet</h1>
 <h1>My Labs</h1>
    <a href="${pageContext.request.contextPath}/reqInfo">test server</a><br>
    <a href="${pageContext.request.contextPath}/Log">log server</a><br>
    <a href="${pageContext.request.contextPath}/cors">CORS Misconfiguration</a><br>
    <a href="${pageContext.request.contextPath}/crlf">CRLF</a><br>
    <a href="${pageContext.request.contextPath}/csrf">CSRF</a><br>
    <a href="${pageContext.request.contextPath}/ClickJacking">ClickJacking</a><br>
    <a href="views/upload.jsp">File Upload</a><br>
    
    
    <form action="${pageContext.request.contextPath}/hello" method="post">
        <input type="text" name="name" placeholder="Enter your name">
        <button type="submit">Submit</button>
    </form>

<body>

</body>
</html>