/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Diagnostico {

    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;
    public ResultSet datos_empleado, datos_ingreso, rs;
    
public void Guardar(String id_Diagnostico,String id_recepcion_vehiculo_placa,String Diag_info_fecha, 
        String Descripcion_diag)  
    {  
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("insert into diagnostico(id_recepcion_vehiculo_placa,Diag_info_fecha, Descripcion_diag) VALUES (?,?,?)");
   
        sql.setString(1, id_recepcion_vehiculo_placa);
        sql.setString(2, Diag_info_fecha);
        sql.setString(3, Descripcion_diag);
      
               
        sql.execute();
        conn.cerrar();
        }
        catch(SQLException ex)
        {
          System.out.println("ERROR AL GUARDAR.."+ex.getMessage());
        }
        conn.cerrar();
    
    }
public void listar_combo_placa(){
  
   try{
             conn.Conectar();
                sql=conn.con.prepareStatement("SELECT * FROM ingreso_taller where `id_recepcion_placa` not in (select id_recepcion_vehiculo_placa from diagnostico)");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos_ingreso=sql.getResultSet();
         }
   catch(SQLException ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
    
public void listar_id_placa(int id_Ingreso_taller){
 
   try{
    conn.Conectar();
    sql=conn.con.prepareStatement("select * from ingreso_taller where id_Ingreso_taller=?");
    sql.setInt(1, id_Ingreso_taller);
    sql.executeQuery();
    datos_ingreso=sql.getResultSet();

   }
    catch(SQLException es){
    System.out.println("error al cargar"+es.getMessage());
    }
 }
 
 
 

 
 
}





