<%
    if (session.getAttribute("name") != null){
        response.sendRedirect("indexUser.jsp");
    }
    if (request.getParameter("l") != null) {
        response.sendRedirect("login.jsp");
    }
    if (request.getParameter("s") != null) {
            response.sendRedirect("signup.jsp");
        }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/index.css">
    <title>School DS</title>
    <link rel="icon" href="img/logo.png" type="image/png">
</head>
<body>
   


<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        
      <a class="navbar-brand" href="#"><img src="img/logo.png" alt=""> Sch <p class="a"></p> <p class="a"></p> l <font>DS</font></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#"><p class="a"></p> &nbsp;Library</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"><p class="a"></p> &nbsp;Contactez-nous</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"><p class="a"></p> &nbsp;News</a>
          </li>
        </ul>
        <form methode="get" class="d-flex">
            <button class="btn btn-outline-success" type="submit" name="s" value="s">Sign-up</button>&nbsp;
            <button class="btn btn-outline-info" type="submit" name="l" value="l">Login</button>
        </form>
      </div>
    </div>
  </nav>
  <div class="container-fluid bg">
    <p class="flavius">School DS</p>
    <p class="quote">Education is the passport to the future, for tomorrow belongs to those who prepare for it today.</p>
    </div>
  <script src="js/index.js"></script>
</body>
</html>
<script src="bootstrap-5.3.0-alpha1-dist/js/bootstrap.js"></script>
