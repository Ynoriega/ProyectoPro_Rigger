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
public class Class_Usuarios {
    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos;// TRABAJAR BASE DE DATOS
    
    public void Guardar_usuario(String Usu_username, String Usu_password, String Usu_tipo)  
    {
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO usuarios  VALUES (?,?,?)");

        sql.setString(1, Usu_username);
        sql.setString(2, Usu_password);
        sql.setString(3, Usu_tipo);
                
        sql.executeUpdate();
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR...");
        }
    }

    public void Guardar_usuario(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void Buscar(String Usu_username)
    {
       
     try
     {
       conn.Conectar();
       sql=conn.con.prepareStatement("select *from usuarios  where Usu_username=?");
       sql.setString(1, Usu_username);
       sql.executeQuery();
       datos=sql.getResultSet();     
     }
    catch(Exception ex)
    {
      System.out.println("ERROR AL BUSCAR DATOS...");
    }
    
    }
    public void Modificar_Usuario(String Usu_username, String Usu_password, String Usu_tipo)
{
try{
   conn.Conectar();
   sql=conn.con.prepareStatement ("UPDATE usuarios SET Usu_password=?, Usu_tipo=? WHERE Usu_username=?");

   
   sql.setString(1, Usu_password);
   sql.setString(2, Usu_tipo);
   sql.setString(3, Usu_username);
  

   int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ACTUALIZADOS CORRECTAMENTE ","usuarios",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR","usuarios",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
}
    public void Eliminar(String Usu_username)
    {
       try
       {
        conn.Conectar();
        sql= conn.con.prepareStatement("DELETE  FROM usuarios WHERE Usu_username=?");
        sql.setString(1, Usu_username);
        
        int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ELIMINADOS CORRECTAMENTE ","USUARIO",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR","USUARIO",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
    }

    
}
