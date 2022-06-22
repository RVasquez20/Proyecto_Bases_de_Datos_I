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
public class Rangos {
    private int edadInicial,edadFinal;
    private Conexion con;

    public Rangos() {
    }

    public Rangos(int edadInicial, int edadFinal) {
        this.edadInicial = edadInicial;
        this.edadFinal = edadFinal;
    }

    public int getEdadInicial() {
        return edadInicial;
    }

    public void setEdadInicial(int edadInicial) {
        this.edadInicial = edadInicial;
    }

    public int getEdadFinal() {
        return edadFinal;
    }

    public void setEdadFinal(int edadFinal) {
        this.edadFinal = edadFinal;
    }
    
     public int agregarRango() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "INSERT INTO RANGOS(EDAD_INICIAL,EDAD_FINAL) VALUES (?,?)";
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            parametro.setInt(1, this.getEdadInicial());
            parametro.setInt(2, this.getEdadFinal());

            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }
     
     
      public int Aplica (String dpi){
          int retorno=0;
          int idRango=0;
     
        try {
            con=new Conexion();
       
            String query="select id_rango from Rangos where (SELECT floor(months_between ( SYSDATE ,fecha_nacimiento)/12) AS edad FROM CIUDADANOS  WHERE DPI="+dpi+") BETWEEN edad_inicial and edad_final";
            con.abrirConexion();
             ResultSet consulta=con.conexionbd.createStatement().executeQuery(query);
             while (consulta.next()) {
                idRango=consulta.getInt("id_rango");
                }
            con.cerrarConexion(); 
            return idRango;
        } catch (SQLException e) {
            System.out.println("Error->"+e.getMessage());
              return retorno;
        }
    }
     
}
