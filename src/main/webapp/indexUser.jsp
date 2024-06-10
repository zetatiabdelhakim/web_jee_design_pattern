<%
    if (session.getAttribute("name") == null){
            response.sendRedirect("login.jsp");
        }
    if (request.getParameter("dec") != null) {
                session.invalidate();
                response.sendRedirect("login.jsp");
                return;
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
            <a class="nav-link" href="#"><p class="a"></p> &nbsp;Contact Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"><p class="a"></p> &nbsp;News</a>
          </li>
        </ul>
        <form class="d-flex">
            <button class="btn btn-outline-info" type="submit" name="dec">Deconnexion</button>
      </div>
    </div>
  </nav>
  <div class="container-fluid bg">
    <p class="flavius">Wellcome <%= session.getAttribute("name") %></p>
    <p class="quote">
        <input class="btn btn-outline-light"  value="Online Courses or Classes" name="Online"></input><br><br>
        <input class="btn btn-outline-light"  value="To do" name="todo"></input><br><br>
        <input class="btn btn-outline-light"  value="My marks" name="marks"></input><br><br>
    </p>
    </div>
    </form>
  <script src="js/index.js"></script>
</body>
</html>
<script src="bootstrap-5.3.0-alpha1-dist/js/bootstrap.js"></script>