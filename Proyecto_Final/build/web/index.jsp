<%-- 
    Document   : index
    Created on : 14/10/2021, 12:15:58 PM
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="sources/images/favicon.ico">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/d34e9eb680.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap" rel="stylesheet"> 
       <!-- -->
           <!-- Link a font awesome para iconos -->
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

  <link rel="stylesheet" href="CSS/bootstrap.css">
  <link rel="stylesheet" href="CSS/animate.css">


  <link rel="stylesheet" href="CSS/main.css">
        <title>Vacunacion Covid 2021</title>
    </head>
    <body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>

  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white sticky" data-offset="500">
      <div class="container">
          <img src="sources/images/Logo.jpg" alt="Logo">

        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Inicio</a>
            </li>
          </ul>
        </div>

      </div>
    </nav>

    <div class="container">
        <div class=" page-banner home-banner " style="
  background-image: url(sources/images/imagen.jpg);
      background-attachment: initial;
    background-position: center;
    background-size: cover;
">
        <div class="row align-items-center flex-wrap-reverse h-100">
          <div class="col-md-6 py-5 wow fadeInLeft">
              <h1 class="mb-5" style="color: #000;">Vacunas Covid 19</h1>
            <p class="text-lg mb-5"style="color: #000;">Sistema de vacunacion covid 19</p>
          </div>
          <div class="col-md-6 py-5 wow zoomIn">
            <div class="img-fluid text-center">
               <!-- <img src="sources/images/imagen.jpg" alt="" style="max-height: 500px;max-width: 400px;">-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>

  <div class="page-section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="card-service wow fadeInUp">
            <div class="header card-header">
                
                <img src="sources/images/ciudadano.png" alt="" style="max-width: 120px; max-height: 120px;">
            </div>
            <div class="body">
              <h5>Registro</h5>
              <a href="Registros.jsp" class="btn btn-primary">Registro</a>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="card-service wow fadeInUp">
            <div class="header card-header">
                <img src="sources/images/inscripcion.png" alt="">
            </div>
            <div class="body">
              <h5>Consultas</h5>
              <a href="Consultas.jsp" class="btn btn-primary">Consultar</a>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="card-service wow fadeInUp">
            <div class="header card-header">
                <img src="sources/images/edades.png" alt="">
            </div>
            <div class="body">
              <h5 >Rangos de edades</h5>
              <a href="Rangos.jsp" class="btn btn-primary">Rangos</a>
            </div>
          </div>
        </div>
      </div>
    </div> <!-- .container -->
  </div> <!-- .page-section -->


  <footer class="page-footer bg-image">
    <div class="container">
      <div class="row">

        <div class="col-lg-6">
          <h3>Vacunacion Covid-19</h3>
          <p>Proyecto de base de datos sobre sistema de vacunacion para covid-10 Hecho por: Ericka Gonzalez y Rodrigo Vasquez</p>

          <div class="social-media-button">
            <a href="#"><i class="fab fa-facebook-square"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
            <a href="#"><i class="fab fa-youtube"></i></a>
          </div>
        </div>
       
        <div class="col-lg-6">
          <h5>Contactanos</h5>
          <p>Ciudad de Guatemala</p>
          <a href="#" class="footer-link">78545236</a><br>
          <a href="#" class="footer-link">ministeriosalud@guatemala.com</a>
        </div>

      </div>
        <br><br>

      <p class="text-center" id="copyright">Copyright &copy; 2021.RE.Enterprises</p>
    </div>
  </footer>

<script src="JS/jquery-3.5.1.min.js"></script>

<script src="JS/bootstrap.bundle.min.js"></script>

<script src="JS/google-maps.js"></script>

<script src="JS/wow.min.js"></script>

<script src="JS/theme.js"></script>
  
    </body>
</html>
