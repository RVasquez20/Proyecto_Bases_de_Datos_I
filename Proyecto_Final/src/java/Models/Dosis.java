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
public class Dosis {
    private Conexion con;
    public Dosis() {
    }
    
    public HashMap listaDeVacunas(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="SELECT d.id_dosis as Id,tv.nombre_vacuna as nombres FROM DOSIS D,tipo_vacuna TV "
                + "WHERE d.id_tipo_vacuna=tv.id_tipovacuna "
                + "AND d.primera_segunda='P'";
         con = new Conexion();
         con.abrirConexion();
            ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("Id"),consulta.getString("nombres"));
            }
         con.cerrarConexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
}
