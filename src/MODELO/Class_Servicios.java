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
public class Class_Servicios {
     CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS

  
    
public void Guardar_servico(int idservicios, String nom_servicio)  
    {
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO servicios VALUES"+nom_servicio);
        
        sql.setString(1, nom_servicio);
       
        sql.executeUpdate();
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR...");
        }
    }

 public ResultSet Mostrar(){
     ResultSet registro=null;   
        
try{
    conn.Conectar();
     String selectSQL="select idservicio as CODIGO, nom_servicio as NOMBRE SERVICIO";
     sql=conn.con.prepareStatement(selectSQL);
     registro=sql.executeQuery(selectSQL);
        
}
catch(SQLException ex)
{
    System.out.println("Error al mostrar"+ex.getMessage());
}
return registro;
}


public void Modificar_servicio(String nom_servicio)
{
try{
   conn.Conectar();
   sql=conn.con.prepareStatement ("UPDATE servicios SET nom_servicio=? WHERE idservicios=?");
   
   sql.setString(1, nom_servicio);
   
   sql.executeUpdate();
   conn.cerrar();
  
   int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ACTUALIZADOS CORRECTAMENTE ","Servicio",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR","Servicio",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
}
public void Buscar(int idservicios)
    {
       
     try
     {
       conn.Conectar();
       sql=conn.con.prepareStatement("select * from servicio  where idservicios=?");
       sql.setInt(1, idservicios);
       sql.executeQuery();
       datos=sql.getResultSet();     
     }
    catch(Exception ex)
    {
      System.out.println("ERROR AL BUSCAR DATOS...");
    }
    
    }
  public void Eliminar(int idservicios)
    {
       try
       {
        conn.Conectar();
        sql= conn.con.prepareStatement("DELETE  FROM servicios WHERE idservicios="+idservicios);
        sql.executeUpdate();
        conn.cerrar();
        
        JOptionPane.showMessageDialog(null,"SE HA BORRADO EL REGISTRO EXICTOSAMENTE","BORRADO",JOptionPane.INFORMATION_MESSAGE);
       
       }
       catch(Exception ex)
       {
        System.out.println("ERROR AL ELIMINAR LOS DATOS...");
       }    
    
    }
   public void llenar_tabla(){
      
 try{
            conn.Conectar();
            sql=conn.con.prepareStatement("select * from servicios ");
            String titulos[]={"CODIGO","NOMBRE SERVICIO"};
            sql.executeQuery();

            rs=sql.executeQuery();
            datos=sql.getResultSet();

            conn.cerrar();
}
   
catch(Exception ex)
         {
             System.out.println("ERROR AL BUSCAR" + ex.getMessage());
         }   
}
}