<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html {
  height:100%;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
 <style>
body {
  margin:0;
}

.bg {
  animation:slide 3s ease-in-out infinite alternate;
  background-image: linear-gradient(-60deg, #6c3 50%, #09f 50%);
  bottom:0;
  left:-50%;
  opacity:.5;
  position:fixed;
  right:-50%;
  top:0;
  z-index:-1;
}

.bg2 {
  animation-direction:alternate-reverse;
  animation-duration:4s;
}

.bg3 {
  animation-duration:5s;
}

.content {
  background-color:rgba(255,255,255,.8);
  border-radius:.25em;
  box-shadow:0 0 .25em rgba(0,0,0,.25);
  box-sizing:border-box;
  left:50%;
  padding:10vmin;
  position:fixed;
  text-align:center;
  top:50%;
  transform:translate(-50%, -50%);
}

h1 {
  font-family:monospace;
}

@keyframes slide {
  0% {
    transform:translateX(-25%);
  }
  100% {
    transform:translateX(25%);
  }
}
</style>

<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="content">
<h1>LogIn</h1>
<form action="Login">
<b>Username</b>  <input type="text" name="suser" style="background-color:PowderBlue;"><br><br>
<b>Password</b>   <input type="password" name="spassword" style="background-color:PowderBlue;"><br><br>
&nbsp&nbsp&nbsp<input type="submit" value="login">

</form><br><br>
<form action="register.jsp">
<input type="submit" value="Create New Account">
</form>
</div>
</body>
</html>