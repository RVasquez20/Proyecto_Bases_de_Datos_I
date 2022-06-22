/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class Fechas {

    private int idFechas;
    private String fechaPrimeraDosis, fechaSegundaDosis;
    private Conexion con;

    public Fechas() {
    }

    public Fechas(int idFechas, String fechaPrimeraDosis, String fechaSegundaDosis) {
        this.idFechas = idFechas;
        this.fechaPrimeraDosis = fechaPrimeraDosis;
        this.fechaSegundaDosis = fechaSegundaDosis;
    }

    public Fechas(String fechaPrimeraDosis, String fechaSegundaDosis) {
        this.fechaPrimeraDosis = fechaPrimeraDosis;
        this.fechaSegundaDosis = fechaSegundaDosis;
    }

    public int getIdFechas() {
        return idFechas;
    }

    public void setIdFechas(int idFechas) {
        this.idFechas = idFechas;
    }

    public String getFechaPrimeraDosis() {
        return fechaPrimeraDosis;
    }

    public void setFechaPrimeraDosis(String fechaPrimeraDosis) {
        this.fechaPrimeraDosis = fechaPrimeraDosis;
    }

    public String getFechaSegundaDosis() {
        return fechaSegundaDosis;
    }

    public void setFechaSegundaDosis(String fechaSegundaDosis) {
        this.fechaSegundaDosis = fechaSegundaDosis;
    }

   /* public int agregarFecha() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "insert into fechas(fecha_primera_dosis)values(DIAS(sysdate,5))";
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }*/
    /*public int agregarFechaSegundaDosis(int idFecha) {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "update Fechas set fecha_segunda_dosis=SYSDATE+28 where id_fechas="+idFecha;
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }
*/
    /*public int lastid() {
        int retorno = 0;
        int exi = 0;

        try {
            con = new Conexion();

            String query = "SELECT max(id_fechas) FROM fechas";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getInt("max(id_fechas)");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }*/
    public int idFechas(int idInscripcion) {
        int retorno = 0;
        int exi = 0;

        try {
            con = new Conexion();

            String query = "select f.id_fechas as id from inscripcion i,fechas f where id_inscripcion="+idInscripcion+" and i.id_fecha=f.id_fechas";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getInt("id");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }
    
    public String fechaActual() {
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "SELECT to_char(sysdate,'DD/MM/RRRR')as actual from dual";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("actual");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }

    public String fechaPrimeraDosis(int idInscripcion) {
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "select to_char(f.fecha_primera_dosis,'DD/MM/RRRR') as primera from inscripcion i,fechas f where i.id_inscripcion=f.id_inscripcion " +
"and f.id_inscripcion="+ String.valueOf(idInscripcion);
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("primera");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }
    
    
       public String MostrarfechaPrimeraDosis(String dpi) {
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "select to_char(f.fecha_primera_dosis,'DD/MM/RRRR') as primera from ciudadanos c,inscripcion i,fechas f where\n" +
"c.dpi="+dpi+" and c.id_ciudadano=i.id_ciudadano" +
" and i.id_inscripcion=f.id_inscripcion ";
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("primera");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }
    
    public String fechaSegundaDosis(int idInscripcion) {
        String retorno = "";
        String exi = "";

        try {
            con = new Conexion();

            String query = "select to_char(f.fecha_segunda_dosis,'DD/MM/RRRR') as segunda from inscripcion i,fechas f where i.id_inscripcion=f.id_inscripcion\n" +
"and f.id_inscripcion="+ String.valueOf(idInscripcion);
            con.abrirConexion();

            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()) {
                exi = consulta.getString("segunda");

            }

            con.cerrarConexion();
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->" + e.getMessage());
            return retorno;
        }
    }

    public boolean fechaValida(String Actual, String Primera) {
        boolean Valido=false;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaPrimerDosis = null;
        Date fechaActual=null;
        try {
            fechaActual = (Date) date.parse(Actual); //String a date
            fechaPrimerDosis = (Date) date.parse(Primera); //String a date
        } catch (ParseException ex) {
            System.out.println("Error ->"+ex.getMessage());
        }

        //comprueba si es que inicio esta después que fecha actual       
        if (fechaPrimerDosis.after(fechaActual)) {
            Valido=false;
        } else {
            Valido=true;
        }
        return Valido;
    }

}
