/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Ciudadanos;
import Models.Fechas;
import Models.Inscripcion;
import Models.Registro;
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
@WebServlet(name = "sr_SegundaDosis", urlPatterns = {"/sr_SegundaDosis"})
public class sr_SegundaDosis extends HttpServlet {

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
    Fechas fecha;
    Inscripcion inscripcion;
    Registro registros;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if ("agregarSegundaDosis".equals(request.getParameter("btn_agregarSegundaDosis"))) {
                String SegundaDosis = null;
                String dpi = request.getParameter("txt_DPI");
                ciudadano = new Ciudadanos();
                int idCiudadano = ciudadano.Existe(dpi);
                //verificar si esta registrado ewn la bd
                if (idCiudadano != 0) {
                    int inscrito = ciudadano.Inscrito(dpi);
                    //Verficamos si el usuario esta inscrito
                    if (inscrito != 0) {
                        inscripcion = new Inscripcion();
                        int idInscripcion = inscripcion.idInscripcion(dpi);
                        fecha = new Fechas();

                        String Actual = fecha.fechaActual();
                        SegundaDosis = fecha.fechaSegundaDosis(idInscripcion);

                        //validamos fecha
                        if (fecha.fechaValida(Actual, SegundaDosis)) {

                        //    int idFecha = fecha.idFechas(idInscripcion);
                            registros = new Registro();
                            //VALIDAMOS SI EL CIUDADANO NO SE HA REGISTRADO PARA LA segunda DOSIS
                            if (registros.verificacionRegistradoSegundaDosis(dpi).equals("")) {
                                int idTipoPrimerVacuna = registros.idPrimeraDosisRegistrada(idInscripcion);
                                int idSegundaDosis=registros.idSegundaDosis(idInscripcion, idTipoPrimerVacuna);
                               int idDepartamento = registros.idDepartamentoRegistrado(idInscripcion);
                               registros = new Registro(idInscripcion, idSegundaDosis, idDepartamento);
                                if (registros.agregarRegistro() > 0) {
                                     mensaje("Segunda Dosis Agregada Correctamente ",response);
                                } else {
                                 mensaje("Error al agregar",response);
                                }
                            } else {
                                 mensaje("Usuario Ya Cuenta con la segunda dosis",response);
                            }

                        } else {
                            mensaje("Error la fecha esta mal, la segunda dosis es: " + SegundaDosis,response);
                        }

                    } else {
                        mensaje("Error el ciudadano no esta inscrito",response);
                    }
                } else {
                     mensaje("Error El ciudadano no esta Registrado",response);
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
                    out.println("<button type='button' onclick=\"location.href='SegundaDosis.jsp'\" class='btn btn-danger' data-dismiss='modal'>Cerrar</button>");
                out.println("</div></div></div></div></div></body></html>");
           }
    }
}
