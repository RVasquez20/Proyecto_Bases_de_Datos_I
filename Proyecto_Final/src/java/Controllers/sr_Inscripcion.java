/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Ciudadanos;
import Models.Fechas;
import Models.Inscripcion;
import Models.Rangos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "sr_Inscripcion", urlPatterns = {"/sr_Inscripcion"})
public class sr_Inscripcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Ciudadanos ciudadano;
    Rangos rango;
    Fechas fechas;
    Inscripcion inscribir;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dpi=request.getParameter("txt_DPI");
            ciudadano=new Ciudadanos();
             if ("agregarInscripcion".equals(request.getParameter("btn_agregarInscripcion"))){ 
                 int id_ciudadano=ciudadano.Existe(dpi);
                 int inscrito=ciudadano.Inscrito(dpi);
                 if ( id_ciudadano > 0 && inscrito==0) {
                     rango=new Rangos();
                     /*out.println("<h1>id: "+id+ "</h1>");
                     out.println("<h1>Nombre: "+ciudadano.getNombreCiudadano()+ "</h1>");
                     out.println("<h1>Apellido: "+ciudadano.getApellidoCiudadano()+ "</h1>");
                     out.println("<h1>Telefono: "+ciudadano.getTelefonoCiudadano()+ "</h1>");
                     out.println("<h1>Direccion: "+ciudadano.getDireccionCiudadano()+ "</h1>");
                     out.println("<h1>DPI: "+ciudadano.getDPI()+ "</h1>");
                     out.println("<h1>Fecha Nacimiento: "+ciudadano.getFechaNacimiento()+ "</h1>");*/
                     int idRango=rango.Aplica(dpi);
                 if ( idRango > 0) {
                     
                    // if ( fechas.agregarFecha() > 0) {
                          //int id_Fecha=fechas.lastid();
                          // out.println("<h1>id: "+id_Fecha+ "</h1>");
                         // inscribir=new Inscripcion(id_ciudadano,id_Fecha,idRango);
                          inscribir=new Inscripcion(id_ciudadano,idRango);
                          if(inscribir.agregarInscripcion()>0){
                              fechas=new Fechas();
                     String fecha=fechas.MostrarfechaPrimeraDosis(dpi);
                     String mensajes="Inscripcion Correcta \n La fecha Asignada para la primera dosis es: "+fecha;
                        mensaje(mensajes,response);
                          // response.sendRedirect("Inscripcion.jsp");
                     }else {
                   mensaje("Error..........error al inscribir",response);
                }
                     
                     // } else {
                  //  out.println("<h1>Error..........al agregar fecha de vacunacion contacte al dba</h1>");
                  //  out.println("<a href ='Registro_Ciudadano.jsp'>Regresar<a>");
               // }
                    
                     } else {
                    mensaje("Error..........Ciudadano con ese DPI No entra en ningun rango actual de edades de vacunacion",response);
                }
                     
                    //pagina diciendo que se registro exitosamente
                  //response.sendRedirect("Inscripcion.jsp");
                } else {
                     mensaje("Error..........Ciudadano con ese DPI no ha sido ingresado al sistema aun o ya esta inscrito",response);
                    
                }
           
             }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public void mensaje(String mensajes,HttpServletResponse response) throws ServletException, IOException {
           try (PrintWriter out = response.getWriter()) {
               out.println("<!DOCTYPE html>");
                out.println("<html lang='es'>");
                out.println("<head>");
                out.println("<title>Agregado</title>");
                out.println("<meta charset='utf-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                out.println("<link rel='stylesheet'href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");   
            out.println("<script type=\"text/javascript\">");
                    out.println("$(document).ready(function(){");
                    out.println("$('#myModal').modal('show');");
                out.println("});");
                out.println("</script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<div class='modal' id='myModal' role='dialog'>");
                out.println("<div class='modal-dialog'>");
                out.println("<div class='modal-content'>");
                out.println("<div class='modal-body'>");             
                out.println("<h4>"+mensajes+"</h4>");              
                    out.println("</div><div class='modal-footer'>");
                    out.println("<button type='button' onclick=\"location.href='Inscripcion.jsp'\" class='btn btn-danger' data-dismiss='modal'>Cerrar</button>");
                out.println("</div></div></div></div></div></body></html>");
           }
    }
}
