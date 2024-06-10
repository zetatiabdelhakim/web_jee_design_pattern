<%
    if (session.getAttribute("name") != null){
        response.sendRedirect("indexUser.jsp");
    }
    String error = "";
    String name = "";
    String password = "";
    String email = "";
    String login = "";
    if (request.getParameter("SignUp") != null){
        error = (String) request.getAttribute("error");
        name = (String) request.getParameter("nom");
        password = (String) request.getParameter("password");
        email = (String) request.getParameter("email");
        login = (String) request.getParameter("login");}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Sign Up</title>
    <link rel="icon" href="img/logo.png" type="image/png">
</head>
<body>
  <div class="container">
    <form action="signup" method="post">
   <h1><font>Sign-Up</font><br> <hr><img src="img/logo.png" alt=""></h1><br>
   <div class="input-group mb-3">
    <span class="input-group-text" >Name</span>
    <input type="text" name="nom" value = <%= '"' + name + '"' %> class="form-control"  aria-label="nom" aria-describedby="basic-addon1">
  </div>
  <div class="input-group mb-3">
    <span class="input-group-text" >Email</span>
    <input type="email" name="email" class="form-control"  value = <%= '"' + email + '"' %> aria-label="Email" aria-describedby="basic-addon1">
  </div>
   <div class="input-group mb-3">
    <span class="input-group-text" >Login</span>
    <input type="text" name="login" value = <%= '"' + login + '"' %> class="form-control"  aria-label="Login" aria-describedby="basic-addon1">
  </div>
  <div class="input-group mb-3">
    <span class="input-group-text" >Password</span>
    <input type="password" name="password" value = <%= '"' + password + '"' %> class="form-control" aria-describedby="basic-addon1">
  </div>
  <p style="color: red;"><%= error  %></p><br>
  <input class="btn btn-info " type="submit" value="SignUp" name="SignUp">
  </form><br><hr>
  <p class="tosignup">Already have an account? <a href="login.jsp">Login</a></p>
  </div>
</body>
</html>
<script src="js/ajust.js"></script>