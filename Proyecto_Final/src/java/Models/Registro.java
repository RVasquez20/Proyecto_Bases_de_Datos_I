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
public class Registro {
 private int idRegistros,idInscripcion,idDosis,idDepartamento;
 private Conexion con;

    public Registro() {
    }

    public Registro(int idInscripcion,  int idDosis, int idDepartamento) {
        this.idInscripcion = idInscripcion;
        this.idDosis = idDosis;
        this.idDepartamento = idDepartamento;
    }

    public int getIdRegistros() {
        return idRegistros;
    }

    public void setIdRegistros(int idRegistros) {
        this.idRegistros = idRegistros;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }


    public int getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(int idDosis) {
        this.idDosis = idDosis;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
 
    
       public String verificacionRegistradoPrimeraDosis(String dpi){
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "select c.nombre_ciudadano as nombre from ciudadanos c,inscripcion i,registros r,dosis d "
                    + "where c.dpi="+dpi+" "
                    + "and c.id_ciudadano=i.id_ciudadano "
                    + "and i.id_inscripcion=r.id_inscripcion "
                    + "and r.id_dosis=d.id_dosis "
                    + "and d.primera_segunda='P'";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("nombre");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }
       
         public String verificacionRegistradoSegundaDosis(String dpi){
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "select c.nombre_ciudadano as nombre from ciudadanos c,inscripcion i,registros r,dosis d "
                    + "where c.dpi="+dpi+" and c.id_ciudadano=i.id_ciudadano "
                    + "and i.id_inscripcion=r.id_inscripcion "
                    + "and r.id_dosis=d.id_dosis "
                    + "and d.primera_segunda='S'";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("nombre");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }
    
        public int agregarRegistro() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "INSERT INTO REGISTROS(ID_INSCRIPCION,FECHA,ID_DOSIS,ID_DEPARTAMENTO)VALUES(?,SYSDATE,?,?)";
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            parametro.setInt(1, this.getIdInscripcion());
            parametro.setInt(2, this.getIdDosis());
            parametro.setInt(3, this.getIdDepartamento());
            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }
        
       public int idPrimeraDosisRegistrada(int idInscripcions) {
        int retorno = 0;
        int exi = 0;

        try {
            con = new Conexion();
con.abrirConexion();
            String query = "SELECT d.id_tipo_vacuna AS ID FROM REGISTROS R,DOSIS D WHERE " +
"r.id_inscripcion="+idInscripcions+" AND R.ID_DOSIS=d.id_dosis " +
"and d.primera_segunda='P'";
            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getInt("ID");
            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error tipo->" + e.getMessage());
            return retorno;
        }
    }
         
   public int idSegundaDosis(int idInscripcions,int idtipo) {
        int retorno = 0;
        int exi = 0;

        try {
            con = new Conexion();
con.abrirConexion();
            String query = "SELECT d.id_dosis AS ID FROM REGISTROS R,DOSIS D WHERE " +
"r.id_inscripcion="+idInscripcions+" and d.id_tipo_vacuna="+idtipo+" and d.primera_segunda='S'";
            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getInt("ID");
            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error id->" + e.getMessage());
            return retorno;
        }
    }    

    public int idDepartamentoRegistrado(int idInscripcion) {
        int retorno = 0;
        int exi = 0;

        try {
            con = new Conexion();
con.abrirConexion();
            String query = "SELECT R.ID_DEPARTAMENTO AS ID FROM REGISTROS R WHERE r.id_inscripcion="+idInscripcion;
            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getInt("ID");
            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error depa->" + e.getMessage());
            return retorno;
        }
    }
    
}
