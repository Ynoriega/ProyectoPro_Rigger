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
public class Class_Recepcion_Cliente {
     CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS

////  nsertar:
//Basta agregar UPPER antes de campo. ej:
//insert into empleado values('cedula',UPPER('nombre'),UPPER('apellido1'),UPPER('apellido2');
//
//Modificar:
//Si tenemos registros y deseamos pasarlos a mayúscula debemos tener en cuenta el campo y la tabla. ej:
//update empleado set apellido2 = UPPER(apellido2)
////
    
public void Guardar_cliente(int Cli_Documento, String Cli_nombre, String Cli_direccion, String Cli_ciudad, String Cli_telefono)  
    {
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO Cliente  VALUES (?,?,?,?,?)");

        sql.setInt(1, Cli_Documento);
        sql.setString(2, Cli_nombre);
        sql.setString(3, Cli_direccion);
        sql.setString(4, Cli_ciudad);
        sql.setString(5, Cli_telefono);
                      
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
     
//     DefaultTableModel mos;
//     mos=new DefaultTableModel();
        
try{
    conn.Conectar();
     String selectSQL="select Cli_Documento as CEDULA, Cli_nombre as NOMBRE, Cli_direccion as DIRECCION,"
             + " Cli_ciudad as CIUDAD, Cli_telefono as TELEFONO from Cliente";
     sql=conn.con.prepareStatement(selectSQL);
     registro=sql.executeQuery(selectSQL);
        
}
catch(SQLException ex)
{
    System.out.println("Error al mostrar"+ex.getMessage());
}
return registro;
}


public void Modificar_Cliente(int Cli_Documento,String Cli_nombre, String Cli_direccion, String Cli_ciudad, String Cli_telefono)
{
try{
   conn.Conectar();
   sql=conn.con.prepareStatement ("UPDATE Cliente SET Cli_nombre=?, Cli_direccion=?, Cli_ciudad=?, Cli_telefono=? WHERE Cli_Documento=?");

   
   sql.setString(1, Cli_nombre);
   sql.setString(2, Cli_direccion);
   sql.setString(3, Cli_ciudad);
   sql.setString(4, Cli_telefono);
   sql.setInt(5, Cli_Documento);
   
   sql.executeUpdate();
//   conn.cerrar();
      //}
   int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ACTUALIZADOS CORRECTAMENTE ","Cliente",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR","Cliente",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
}
public void Buscar(int Cli_Documento)
    {
       
     try
     {
       conn.Conectar();
       sql=conn.con.prepareStatement("select * from Cliente  where Cli_Documento=?");
       sql.setInt(1, Cli_Documento);
       sql.executeQuery();
       datos=sql.getResultSet();     
     }
    catch(Exception ex)
    {
      System.out.println("ERROR AL BUSCAR DATOS...");
    }
    
    }
  public void Eliminar(int Documento)
    {
       try
       {
        conn.Conectar();
        sql= conn.con.prepareStatement("DELETE  FROM cliente WHERE Cli_Documento="+Documento);
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
            sql=conn.con.prepareStatement("select * from cliente ");
            String titulos[]={"DOCUMENTO","NOMBRE", "DIRECCIÓN","CIUDAD","TELEFONO" };
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