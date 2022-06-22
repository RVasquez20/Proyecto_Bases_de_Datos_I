<%-- 
    Document   : RegistroPrimeraDosis
    Created on : 19/10/2021, 05:18:05 PM
    Author     : rodri
--%>

<%@page import="Models.Departamentos"%>
<%@page import="java.util.HashMap"%>
<%@page import="Models.Dosis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Integer idInscripcion=(Integer)request.getAttribute("idInscripcion");
%>
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
        <script src="JS/AllInOne.js"></script>
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
          
          </ul>
        </div>

      </div>
    </nav>
  </header>
      <br><br><br><br><br><br><br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Aplicacion Primera Dosis
			</h3>
                    <br>
                   
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
                    <br><br>
        <form action="sr_PrimeraDosis" method="post" class="form-group">
 
       <input type="hidden" name="txt_idInscripcion" id="txt_idInscripcion" class="form-control" value =<%=idInscripcion%> readonly><br>
<label for="lbl_idDosis">Vauna:</label>
                 <select name="txt_Dosis" id="txt_Dosis" class="form-control">
                <%
                Dosis dosis=new Dosis();
               HashMap<String,String> dropdosis = dosis.listaDeVacunas();
                 out.println("<option value='0'>Seleccione</option>");
                         for (String i:dropdosis.keySet()){
                             out.println("<option value='" + i + "'>" + dropdosis.get(i) +"</option>");
                         }
                %>
                 </select>
                <br>
                <br>
                <label for="lbl_idDepartamentos">Departamentos:</label>
                 <select name="txt_Departamento" id="txt_Departamento" class="form-control">
                <%
                Departamentos depa=new Departamentos();
               HashMap<String,String> dropdepartamentos = depa.listaDeDepartamentos();
                 out.println("<option value='0'>Seleccione</option>");
                         for (String i:dropdepartamentos.keySet()){
                             out.println("<option value='" + i + "'>" + dropdepartamentos.get(i) +"</option>");
                         }
                %>
                 </select>
                 <br>
                 <br>
                 <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-success btn-lg">Agregar Primera Dosis</button>
       </form>
      </div>
		<div class="col-md-4">
		</div>
	</div>
</div>
      <br><br><br><br><br><br>
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
    </body>
</html>
