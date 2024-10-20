<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Files</title>
</head>
<body>


<h2>Upload File</h2>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <label for="file">Select file:</label>
    <input type="file" name="file" id="file"><br><br>
    <label for="filename">Enter new filename (with extension):</label>
    <input type="text" name="filename" id="filename"><br><br>
    <input type="submit" value="Upload">
</form>

<h2>View File</h2>
<form action="${pageContext.request.contextPath}/view" method="get">
<input type="text" name="filename" placeholder="file you want to access">
<button type="submit">Submit</button>
</form>

</body>
</html>