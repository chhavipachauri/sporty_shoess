 <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
@keyframes color {
  0%   { background: #33CCCC; }
  20%  { background: #33CC36; }
  40%  { background: #B8CC33; }
  60%  { background: #FCCA00; }
  80%  { background: #33CC36; }
  100% { background: #33CCCC; }
}
</style>
<meta charset="ISO-8859-1">
<title>Walking Shoes List</title>
</head>
<style>
body {
  background: #33CCCC; /* Fallback */
  animation: color 9s infinite linear;
  text-align: center;
  padding: 2em;
}
</style>

<center>
<%List<GYM> list=(List<GYM>)request.getAttribute("list");  %>
<table border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="100%">
<tr><th>ID</th><th>GYM Shoes Model</th><th>Price</th><th>Size</th><th>Action</th></tr>
<% for(GYM s:list){%>
<tr><td><%=s.getGid() %><td><%=s.getGname() %></td><td><%=s.getGprice()%></td><td><%=s.getGsize()%></td><td><a href="gymupdate.jsp">Edit</a>&nbsp &nbsp<a href="gdelete.jsp">Delete</a></td></tr>
<%}%> <br><br>
</table><br><br>
<form action="gym.jsp">
<input type="submit" value="Insert More GYM Shoes">
</form>
</center>
</body>
</html>