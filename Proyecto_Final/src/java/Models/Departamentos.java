/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author rodri
 */
public class Departamentos {
     private Conexion con;
    public Departamentos() {
    }
    
    public HashMap listaDeDepartamentos(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="SELECT ID_DEPARTAMENTO,DEPARTAMENTO FROM DEPARTAMENTOS";
         con = new Conexion();
         con.abrirConexion();
            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("ID_DEPARTAMENTO"),consulta.getString("DEPARTAMENTO"));
            }
         con.cerrarConexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
}
