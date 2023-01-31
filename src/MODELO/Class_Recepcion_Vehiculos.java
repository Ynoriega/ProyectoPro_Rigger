/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Recepcion_Vehiculos {
 
    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS
    public boolean verificar=false;
    
public void Guardar_Datos_Vehiculo(String Veh_placa, int id_info_marcas, int id_info_clase_de_vehiculo, int id_info_servicio, int id_info_cliente,
                                   String Veh_modelo, String Veh_color, String Veh_cilindraje, String Veh_num_motor, String Veh_num_chasis, String Veh_kilometraje,
                                   String Veh_Estado, String vehiculo_marca, String vehiculo_clase, String vehiculo_servicio, String doc_cliente)  
    {
        try
        {
       
        verificar=false;
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO Vehiculo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        
        sql.setString(1, Veh_placa);
        sql.setInt(2, id_info_marcas);
        sql.setInt(3, id_info_clase_de_vehiculo);
        sql.setInt(4, id_info_servicio);
        sql.setInt(5, id_info_cliente);
        sql.setString(6, Veh_modelo);
        sql.setString(7, Veh_color);
        sql.setString(8, Veh_cilindraje);
        sql.setString(9, Veh_num_motor);
        sql.setString(10, Veh_num_chasis);
        sql.setString(11, Veh_kilometraje);
        sql.setString(12, Veh_Estado);
        sql.setString(13, vehiculo_marca);
        sql.setString(14, vehiculo_clase);
        sql.setString(15, vehiculo_servicio);
        sql.setString(16, doc_cliente);
       
        
        int a = sql.executeUpdate();
        if(a>0)
        {
            verificar=true;
        }        
        conn.cerrar();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR..."+ex.getMessage());
        }
    }

    
public void Buscar(String Veh_placa)
{
 try
 {
  conn.Conectar();
  sql=conn.con.prepareStatement("SELECT *FROM vehiculo  where Veh_placa=?");
  sql.setString(1, Veh_placa);
  sql.executeQuery();
  datos=sql.getResultSet();
 }
 catch(Exception ex)
 {
 System.out.println("ERROR AL BUSCAR DATOS...");   
}
    
}

public void Eliminar(String Veh_placa)
  {
       try
       {
        conn.Conectar();
        sql= conn.con.prepareStatement("DELETE  FROM vehiculo WHERE Veh_placa='?'");
        sql.executeUpdate();
        conn.cerrar();
        
        JOptionPane.showMessageDialog(null,"SE HA BORRADO EL REGISTRO EXICTOSAMENTE","BORRADO",JOptionPane.INFORMATION_MESSAGE);
       
       }
       catch(Exception ex)
       {
        System.out.println("ERROR AL ELIMINAR LOS DATOS...");
       }    
    
    } 

public void Actualizar(String Veh_placa,String Veh_marca, String Veh_modelo, String Veh_color, String Veh_cilindraje,
        String Veh_clase_de_vehiculo, String Veh_servicio, String Veh_num_motor, String Veh_num_chasis, 
        String Veh_kilometraje, String Veh_Estado, String id_info_cliente)
{
    
    System.out.println("campo marca "+Veh_marca);
    System.out.println("campo maodelo "+Veh_modelo);
    System.out.println("campo color "+Veh_color);
    System.out.println("campo cilin "+Veh_cilindraje);
    System.out.println("campo clase "+Veh_clase_de_vehiculo);
    System.out.println("campo servicio "+Veh_servicio);
    System.out.println("campo motor "+Veh_num_motor);
    System.out.println("campo chasis "+Veh_num_chasis);
    System.out.println("campo kilometraje "+Veh_kilometraje);
    System.out.println("campo estado "+Veh_Estado);
    System.out.println("campo estado "+id_info_cliente);
    
    
    
    try 
  {
  conn.Conectar();
  sql=conn.con.prepareStatement("SELECT *FROM vehiculo  where Veh_placa=?");
  sql.setString(1, Veh_placa);
  sql.executeQuery();
  datos=sql.getResultSet();
   sql=conn.con.prepareStatement("UPDATE vehiculo SET Veh_marca=?,"
         
           + " Veh_modelo=?,"
           + " Veh_color=?,"
           + " Veh_cilindraje=?,"
           + " Veh_clase_de_vehiculo=?,"
           + " Veh_servicio=?, "
           + " Veh_num_motor=?,"
           + " Veh_num_chasis=?,"
           + " Veh_Kilometraje=?,"
           + " Veh_Estado=?"
           + " WHERE Veh_placa=?");
   
   sql.setString(1, Veh_marca);
   sql.setString(2, Veh_modelo);
   sql.setString(3, Veh_color);
   sql.setString(4, Veh_cilindraje);
   sql.setString(5, Veh_clase_de_vehiculo);
   sql.setString(6, Veh_servicio);
   sql.setString(7, Veh_num_motor);
   sql.setString(8, Veh_num_chasis);
   sql.setString(9, Veh_kilometraje);
   sql.setString(10, Veh_Estado);
   sql.setString(11, Veh_placa);
   
   sql.executeUpdate();
   conn.cerrar();
  }  
  
 catch(SQLException ErrMod)
  {
     
  System.out.println("ERROR AL ACTUALIZAR..."+ErrMod.getMessage());
  }
}

public void listar_combo_cliente(){
  
   try{
             conn.Conectar();
             sql=conn.con.prepareStatement("select * from cliente");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR"+ex.getMessage());
    } 
    }
  
 public void listar_cliente(int Cli_Documento){
 
   try{
    conn.Conectar();
    sql=conn.con.prepareStatement("select * from cliente where Cli_Documento=?");
    sql.setInt(1, Cli_Documento);
    sql.executeQuery();
    datos=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
    }
 //************************************//Metodo de listar marac de vehiculo****************************
 public void Listar_Combo_Marca()
 {
     try
     {
         conn.Conectar();
             sql=conn.con.prepareStatement("select * from marcas");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
     }
     catch(Exception ex)
     {
         System.out.println("ERROR AL BUSCAR"+ex.getMessage());
     }
 }
 
 public void Listar_Marca(int idmarcas)
 {
     try
     {
          conn.Conectar();
          sql=conn.con.prepareStatement("select * from marcas where idmarcas=?");
          sql.setInt(1, idmarcas);
          sql.executeQuery();
          datos=sql.getResultSet();
     }
     catch(Exception ex)
     {
         System.out.println("ERROR AL BUSCAR"+ex.getMessage());
     }
 }
 //*********************************//****************************************************
 
 public void Listar_combo_clase()
 {
     try
     {
         conn.Conectar();
         sql=conn.con.prepareStatement("SELECT * FROM tipo_vehiculos");
         
         rs=sql.executeQuery();
         sql.executeQuery();
         datos=sql.getResultSet();
                 
     }
     catch(Exception ex)
     {
         System.out.println("ERROR AL BUSCAR"+ex.getMessage());
     }
 }
 
 public void Listar_clases(int idtipov)
 {
     try
     {
     conn.Conectar();
     sql=conn.con.prepareStatement("select * from tipo_vehiculos where idtipov=?");
     sql.setInt(1, idtipov);
     sql.executeQuery();
     datos=sql.getResultSet();
     }
     catch(Exception ex)
     {
         System.out.println("ERROR AL BUSCAR"+ex.getMessage());
     }
 }
public void listar_ComboBox_Servicio()
{
    try
    {
        conn.Conectar();
        sql=conn.con.prepareStatement("SELECT * FROM tipo_servicio");
        
        rs=sql.executeQuery();
        sql.executeQuery();
        datos=sql.getResultSet();
    }
    catch(Exception ex)
    {
        System.out.println("ERROR AL BUSCAR"+ex.getMessage());
    }
}

public void Listar_servicio(int idtipserv)
{
    try
    {
        conn.Conectar();
        sql=conn.con.prepareStatement("select * from tipo_servicio where idtipserv=?");
        sql.setInt(1, idtipserv);
        sql.executeQuery();
        datos=sql.getResultSet();
    }
    catch(Exception ex)
    {
        System.out.println("ERROR AL BUSCAR"+ex.getMessage());
    }
}


}


