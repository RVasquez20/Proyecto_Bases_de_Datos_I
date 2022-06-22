 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;

/**
 *
 * @author rodri
 */
public class Conexion {

    public Connection conexionbd;
    public final String SID = "xe";
    public final String Port = "1521";
    public final String Host = "localhost";
    public final String url = String.format("jdbc:oracle:thin:@%s:%s:%s", Host, Port, SID);
    public final String esquema = "USR_INGRESO";
    public final String pass = "UMG123";
    public final String JDBC = "oracle.jdbc.driver.OracleDriver";

    public Connection abrirConexion() {
        try {
            Class.forName(JDBC);
            conexionbd = DriverManager.getConnection(url, esquema, pass);
            System.out.println("Exito");
        } catch (Exception e) {
            System.out.println("Error al conectar : " + e.getMessage());
        }
        return conexionbd;
    }

    public void cerrarConexion() {
        try {
            conexionbd.close();
        } catch (SQLException ex) {
            System.out.println("Error->" + ex.getMessage());
        }
    }

    public final String SID_CONSULTA = "xe";
    public final String Port_CONSULTA = "1521";
    public final String Host_CONSULTA = "localhost";
    public final String url_CONSULTA = String.format("jdbc:oracle:thin:@%s:%s:%s", Host, Port, SID);
    public final String esquema_CONSULTA = "USR_CONSULTA";
    public final String pass_CONSULTA = "umg123";
 public Connection abrirConexionConsulta() {
        try {
            Class.forName(JDBC);
            conexionbd = DriverManager.getConnection(url_CONSULTA, esquema_CONSULTA, pass_CONSULTA);
            System.out.println("Exito USR_CONSULTA");
        } catch (Exception e) {
            System.out.println("Error al conectar a consulta : " + e.getMessage());
        }
        return conexionbd;
    }

    public void cerrarConexionConsulta() {
        try {
            conexionbd.close();
        } catch (SQLException ex) {
            System.out.println("Error-> cerrar consulta :" + ex.getMessage());
        }
    }
}
