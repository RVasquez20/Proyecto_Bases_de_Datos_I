/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class Inscripcion {
    private int idIncripcion,idCiudadano,idRango;
    private String  fechaInscripcion;
    private Conexion con;

 
    public Inscripcion() {
    }

    public Inscripcion(int idCiudadano, int idRango) {
        this.idCiudadano = idCiudadano;
        this.idRango = idRango;
    }

    public int getIdIncripcion() {
        return idIncripcion;
    }

    public void setIdIncripcion(int idIncripcion) {
        this.idIncripcion = idIncripcion;
    }

    public int getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

   

    public int getIdRango() {
        return idRango;
    }

    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
      public int agregarInscripcion() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "INSERT INTO INSCRIPCION(ID_CIUDADANO,ID_RANGO,FECHA_INSCRIPCION) VALUES (?,?,SYSDATE)";
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            parametro.setInt(1, this.getIdCiudadano());
            parametro.setInt(2, this.getIdRango());

            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }
    
      
 public int idInscripcion (String dpi){
          int retorno=1;
          int id=0;
     
        try {
            con=new Conexion();
       
            String query="select i.id_inscripcion as id from inscripcion i,ciudadanos c where i.id_ciudadano=c.id_ciudadano and c.dpi="+dpi;
            con.abrirConexion();
           
            
           
             ResultSet consulta=con.conexionbd.createStatement().executeQuery(query);
             while (consulta.next()) {
                id=consulta.getInt("id");
                }
                   
                    
            con.cerrarConexion(); 
            return id;
        } catch (SQLException e) {
            System.out.println("Error->"+e.getMessage());
              return retorno;
        }
    }
      
}
