/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 * 
 */
public class Class_Reparacion {

    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;
    public ResultSet datos_empleado, datos_ingreso, rs;
    
public void Guardar(int id_info_servicio, int id_diagnostico, String id_info_diagnostico, double valor_servic, String info_servicio, String Rep_Observaciones)
               
    {  
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO reparacion (id_info_servicio, id_diagnostico, id_info_diagnostico, valor_servic, info_servicio, Rep_Observaciones)VALUES(?,?,?,?,?,?)");
        sql.setInt(1, id_diagnostico);
        sql.setInt(2, id_info_servicio);
        sql.setString(3, id_info_diagnostico);
        sql.setDouble(4, valor_servic);
        sql.setString(5, info_servicio);
        sql.setString(6, Rep_Observaciones);
               
        sql.execute();
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR..."+ex.getMessage());
        }
        conn.cerrar();
    
    } 



public void listar_combo_ingreso(){
  
   try{
             conn.Conectar();
             sql=conn.con.prepareStatement("select * from diagnostico where id_recepcion_vehiculo_placa	not in(select id_info_diagnostico from reparacion)");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos_ingreso=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
    
 public void listar_id_ingreso(int id_Diagnostico){
 
   try{
    conn.Conectar();
    sql=conn.con.prepareStatement("select * from diagnostico where id_Diagnostico=?");
    sql.setInt(1, id_Diagnostico);
    sql.executeQuery();
    datos_ingreso=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
 }
 public void listar_combo_Servicio(){
  
   try{
             conn.Conectar();
             sql=conn.con.prepareStatement("select * from servicios");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos_empleado=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
    
 public void listar_id_Servicio(int idservicios)
 {
 
   try{
    conn.Conectar();
    sql=conn.con.prepareStatement("select * from servicios where idservicios=?");
    sql.setInt(1, idservicios);
    sql.executeQuery();
    datos_empleado=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
 }
 
 

 
 
}





