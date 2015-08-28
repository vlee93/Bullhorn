<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>BullHorn</title>

</head>
<body>

<div class="jumbotron" align = "center">
  <h1> Welcome to Bullhorn</h1>      
  <p>Bullhorn is the new website for staying connected.</p>
  <p> Please login or create an account in order to make a post.</p>
</div>

<div align="center">
<form action="UserLogin" method="post">
<label >Username: </label>
<input  type="text" name="username" ><br>
<label >Password: </label>
<input  type="text" name="password" ><br>
<input type="submit" value="Login" id="submit">
</form>
<form  action="UserLogin" method="post">
<input type="submit" value="CreateAccount" id="submit">
</form>
</div>

</body>
</html>