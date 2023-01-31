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
 */
public class Class_Salida_Taller {
    
        CONTROLADOR.Class_CONEXION  conn=new CONTROLADOR.Class_CONEXION ();
        public PreparedStatement sql,sql2;// TRABAJO CON SQL
        public ResultSet datos, rs, rs2;// TRABAJO BASE DE DATOS
        
    public void llenarcombo(){
        try
          {
              conn.Conectar();
              sql=conn.con.prepareStatement("select * from reparacion where id_info_diagnostico not in(select 	id_reparacion_placa from salida_taller)");
              rs=sql.executeQuery();
              sql.executeQuery();
              datos=sql.getResultSet();
              //conn.cerrar();
          }
          catch(Exception exCom)
          {
          System.out.println("error al cargar los datos"+exCom.getMessage());
          }
         
      }
    
    public void ListarCombo(String id_recepcion_vehiculo_placa)
    {
        try
        {
            conn.Conectar();
            sql=conn.con.prepareStatement("select * from empleados where id_recepcion_vehiculo_placa = ?");
            rs=sql.executeQuery();
            sql.executeQuery();
            datos=sql.getResultSet();
        }
        catch(Exception ex)
        {
            System.out.println("error al cargar los datos"+ex.getMessage());
        }
        conn.cerrar();
    }
     public void ListarCombo2(String id_recepcion_vehiculo_placa)
    {
        try
        {
            conn.Conectar();
            sql=conn.con.prepareStatement("select Veh_placa from vehiculo where Veh_placa  = ?");
            sql.setString(1, id_recepcion_vehiculo_placa);
            rs=sql.executeQuery();
            sql.executeQuery();
            datos=sql.getResultSet();
        }
        catch(Exception ex)
        {
            System.out.println("error al cargar los datos"+ex.getMessage());
        }
       
    }
    public void Guardar( String fecha_salida_taller,String id_reparacion_placa)
               
    {  
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO salida_taller( fecha_salida_taller, id_reparacion_placa)VALUES(?,?)");
       
        sql.setString(1, fecha_salida_taller);
        sql.setString(2, id_reparacion_placa);
       
               
        sql.execute();
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR..."+ex.getMessage());
        }
        conn.cerrar();
    
    } 
}
