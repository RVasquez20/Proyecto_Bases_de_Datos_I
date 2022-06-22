/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class Ciudadanos {
    private String nombreCiudadano,apellidoCiudadano,telefonoCiudadano,DPI,direccionCiudadano,fechaNacimiento;
    private Conexion con;
    private int idCiudadano;

    public Ciudadanos(String nombreCiudadano, String apellidoCiudadano, String telefonoCiudadano, String DPI, String direccionCiudadano, String fechaNacimiento, int idCiudadano) {
        this.nombreCiudadano = nombreCiudadano;
        this.apellidoCiudadano = apellidoCiudadano;
        this.telefonoCiudadano = telefonoCiudadano;
        this.DPI = DPI;
        this.direccionCiudadano = direccionCiudadano;
        this.fechaNacimiento = fechaNacimiento;
        this.idCiudadano = idCiudadano;
    }

    public Ciudadanos() {
    }

    public Ciudadanos(String nombreCiudadano, String apellidoCiudadano, String telefonoCiudadano, String DPI, String direccionCiudadano, String fechaNacimiento) {
        this.nombreCiudadano = nombreCiudadano;
        this.apellidoCiudadano = apellidoCiudadano;
        this.telefonoCiudadano = telefonoCiudadano;
        this.DPI = DPI;
        this.direccionCiudadano = direccionCiudadano;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCiudadano() {
        return nombreCiudadano;
    }

    public void setNombreCiudadano(String nombreCiudadano) {
        this.nombreCiudadano = nombreCiudadano;
    }

    public String getApellidoCiudadano() {
        return apellidoCiudadano;
    }

    public void setApellidoCiudadano(String apellidoCiudadano) {
        this.apellidoCiudadano = apellidoCiudadano;
    }

    public String getTelefonoCiudadano() {
        return telefonoCiudadano;
    }

    public void setTelefonoCiudadano(String telefonoCiudadano) {
        this.telefonoCiudadano = telefonoCiudadano;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getDireccionCiudadano() {
        return direccionCiudadano;
    }

    public void setDireccionCiudadano(String direccionCiudadano) {
        this.direccionCiudadano = direccionCiudadano;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int agregarCiudadano() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            con = new Conexion();
            String query = "INSERT INTO CIUDADANOS(NOMBRE_CIUDADANO,APELLIDO_CIUDADANO,TELEFONO_CIUDADANO,DPI,DIRECCION_CIUDADANO,FECHA_NACIMIENTO) VALUES (?,?,?,?,?,?)";
            con.abrirConexion();
            parametro = (PreparedStatement) con.conexionbd.prepareStatement(query);
            parametro.setString(1, this.getNombreCiudadano());
            parametro.setString(2, this.getApellidoCiudadano());
            parametro.setString(3, this.getTelefonoCiudadano());
            parametro.setString(4, this.getDPI());
            parametro.setString(5, this.getDireccionCiudadano());
            parametro.setString(6, this.getFechaNacimiento());

            retorno = parametro.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }
    
    public int Existe(String dpi){
          int retorno=0;
          int exi=0;
     
        try {
            con=new Conexion();
       
            String query="select ID_CIUDADANO,NOMBRE_CIUDADANO,APELLIDO_CIUDADANO,TELEFONO_CIUDADANO,DPI,DIRECCION_CIUDADANO,FECHA_NACIMIENTO from CIUDADANOS where DPI="+dpi;
            con.abrirConexion();
           
            
           
             ResultSet consulta=con.conexionbd.createStatement().executeQuery(query);
             while (consulta.next()) {
                exi=consulta.getInt("ID_CIUDADANO");
                this.setNombreCiudadano(consulta.getString("NOMBRE_CIUDADANO"));
                this.setApellidoCiudadano(consulta.getString("APELLIDO_CIUDADANO"));
                this.setTelefonoCiudadano(consulta.getString("TELEFONO_CIUDADANO"));
                this.setDPI(consulta.getString("DPI"));
                this.setDireccionCiudadano(consulta.getString("DIRECCION_CIUDADANO"));
                this.setFechaNacimiento(consulta.getString("FECHA_NACIMIENTO"));
                }
                   
                    
            con.cerrarConexion(); 
            return exi;
        } catch (SQLException e) {
            System.out.println("Error->"+e.getMessage());
              return retorno;
        }
    }
     public int Existe2(String dpi){
          int retorno=0;
          int exi=0;
     
        try {
            con=new Conexion();
       
            String query="select ID_CIUDADANO from CIUDADANOS where DPI="+dpi;
            con.abrirConexion();
           
            
           
             ResultSet consulta=con.conexionbd.createStatement().executeQuery(query);
             while (consulta.next()) {
                exi=consulta.getInt("ID_CIUDADANO");   
                }
                   
                    
            con.cerrarConexion(); 
            return exi;
        } catch (SQLException e) {
            System.out.println("Error existe2->"+e.getMessage());
              return retorno;
        }
    }
    
    
    
          public int Inscrito (String dpi){
          int retorno=1;
          int id=0;
     
        try {
            con=new Conexion();
       
            String query="select c.dpi as dpi from inscripcion i,ciudadanos c where i.id_ciudadano=c.id_ciudadano and c.dpi="+dpi;
            con.abrirConexion();
           
            
           
             ResultSet consulta=con.conexionbd.createStatement().executeQuery(query);
             while (consulta.next()) {
                id=consulta.getInt("dpi");
                }
                   
                    
            con.cerrarConexion(); 
            return id;
        } catch (SQLException e) {
            System.out.println("Error->"+e.getMessage());
              return retorno;
        }
    }
    
          
  public DefaultTableModel ConsultaRegistro(String dpi){         
DefaultTableModel tabla = new DefaultTableModel();
 try{
     con = new Conexion();
     con.abrirConexionConsulta();
      String query = "select ID_Registros as id,NOMBRE_CIUDADANO,APELLIDO_CIUDADANO,TELEFONO_CIUDADANO,DPI,DIRECCION_CIUDADANO,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/RRRR')as FECHA_NACIMIENTO  " +
"from registros where dpi="+dpi;
      ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
      String encabezado[] = {"ID_Registros","NOMBRE","APELLIDO","TELEFONO","DPI","DIRECCION","FECHA DE NACIMIENTO"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("NOMBRE_CIUDADANO");
          datos[2] = consulta.getString("APELLIDO_CIUDADANO");
          datos[3] = consulta.getString("TELEFONO_CIUDADANO");
          datos[4] = consulta.getString("DPI");
          datos[5] = consulta.getString("DIRECCION_CIUDADANO");
          datos[6] = consulta.getString("FECHA_NACIMIENTO");
          tabla.addRow(datos);
      
      }
      
     con.cerrarConexionConsulta();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    
   public DefaultTableModel contanciaVacunacion(String dpi){         
DefaultTableModel tabla = new DefaultTableModel();
 try{
     con = new Conexion();
     con.abrirConexionConsulta();
      String query = "select a.id_aplicaciones as id,a.dosis as Dosis,a.tipo_vacuna as Tipo,TO_CHAR(a.fecha,'DD/MM/RRRR') as Fecha,a.departamento as Lugar from Aplicaciones A " +
"WHERE a.dpi=" +dpi;
      ResultSet consulta = con.conexionbd.createStatement().executeQuery(query);
      String encabezado[] = {"ID_Aplicacion","Dosis","Tipo de Vacuna","Fecha de Vacunacion","Lugar de Vacunacion"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[5];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("Dosis");
          datos[2] = consulta.getString("Tipo");
          datos[3] = consulta.getString("Fecha");
          datos[4] = consulta.getString("Lugar");
          
          tabla.addRow(datos);
      
      }
      
     con.cerrarConexionConsulta();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    
}
