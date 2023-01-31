/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Ingreso_Taller {

    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;
    public ResultSet datos,rs;
    
public void GuardarIngresoTaller(String Ingreso_taller_fecha, String id_recepcion_placa)
{
    try
    {
        
     

        conn.Conectar();
     // sql=conn.con.prepareStatement("INSERT INTO ingreso_taller(Ingreso_taller_fecha, id_recepcion_placa) VALUES(?,?)");
         sql=conn.con.prepareStatement("INSERT INTO ingreso_taller (ingreso_taller_fecha, id_recepcion_placa) "
                                      + "VALUES (?,?)");
         sql.setString(1, Ingreso_taller_fecha);
         sql.setString(2, id_recepcion_placa);
         
         sql.executeUpdate();
         conn.cerrar();
    }
    catch(Exception ex)
    {
        System.out.println("ERROR AL GUARDAR..."+ ex.getMessage());
        conn.cerrar();
    }
}
public void listar_combo_ingreso(){
  
   try{
             conn.Conectar();
//                sql=conn.con.prepareStatement("SELECT DISTINCT id_recepcion_placa, id_recepcion_vehiculo_placa`\n" +
//"FROM ingreso_taller, diagnostico WHERE id_recepcion_placa=id_recepcion_vehiculo_placa");
             sql=conn.con.prepareStatement("SELECT * FROM `vehiculo` WHERE `Veh_placa` not in (select id_recepcion_placa from ingreso_taller) ");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
    
 public void listar_vehiculo(String Veh_placa){
 
   try{
    conn.Conectar();
//    sql=conn.con.prepareStatement("SELECT DISTINCT id_recepcion_placa, id_recepcion_vehiculo_placa`\n" +
//"FROM ingreso_taller, diagnostico WHERE id_recepcion_placa=?");
    sql=conn.con.prepareStatement("select * from vehiculo where Veh_placa=?");
    sql.setString(1, Veh_placa);
    sql.executeQuery();
    datos=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
 }
    
}

