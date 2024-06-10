<%
    if (session.getAttribute("name") != null){
            response.sendRedirect("indexUser.jsp");
        }
            String error = "";
            String password = "";
            String email = "";
            if (request.getParameter("login") != null){
                error = (String) request.getAttribute("error");
                password = (String) request.getParameter("password");
                email = (String) request.getParameter("email");
        }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
    <link rel="icon" href="img/logo.png" type="image/png">
</head>
<body>
  <div class="container">
    <br><br>
    <form action="login" method="post">
   <h1><font>Login</font><br> <hr><img src="img/logo.png" alt=""></h1><br>
   <p style="color: red;"><%= error  %></p><br>
   <div class="input-group mb-3">
    <span class="input-group-text">Email</span>
    <input type="text" class="form-control"  value = <%= '"' + email + '"' %> aria-label="Login" aria-describedby="basic-addon1" name="email">
  </div>
  <div class="input-group mb-3">
    <span class="input-group-text" >Password</span>
    <input type="password" class="form-control"  value = <%= '"' + password + '"' %> aria-describedby="basic-addon1" name="password">
  </div>
  <p><input class="checkbox" type="checkbox" name="remember" id=""> Remembre me</p> <p class="a"><a class="password" href="#">Forgot Password?</a></p><br>
  <input class="btn btn-info "type="submit" value="Log In" name="login">
  <br>
  </form><br><hr>
  <p class="tosignup">New to School DS? <a href="signup.jsp">Sign Up</a></p>
  </div>
</body>
</html>
<script src="js/ajust.js"></script>
