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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Home.jsp">Bullhorn</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="Home.jsp">Make a Post</a></li>
        <li><a href="News">News Feed</a></li>
        <li><a href="Profile">User Profile</a></li>
        <li><a href="Search.jsp">Search</a></li>
      </ul>
    </div>
  </div>
</nav>

	<div class= "panle panel-primary col-sm-6 col-sm-offset-3">
		<div class ="panel-heading">
			<h1 align = center> BullHorn </h1>		
		</div>	
		<div class="panel-body">
			<form role="form" action="PostServ" method = "post">
				<div class="form-group">  
					<label for="post">Create New Post (140 char):</label>
					<textarea name= "post" class="form-control" rows="5" placeholder= "Express yourself!"></textarea>
					</div> 
					<div class = "form-group"> 
					<input type="submit" value="submit" id="submit">
				</div>  
			</form>			
		</div>
	</div>
</body>
</html>