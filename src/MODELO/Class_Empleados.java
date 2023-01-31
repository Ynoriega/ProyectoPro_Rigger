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
import java.sql.DriverManager;
/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Empleados {
     CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS
    
    
    
    public void Guardar_Empleado(String  Emp_Documento, String Emp_Nombres, String Emp_Apellidos, String id_Usuarios)  
    {
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO empleados  VALUES (?,?,?,?)");

        sql.setString(1, Emp_Documento);
        sql.setString(2, Emp_Nombres);
        sql.setString(3, Emp_Apellidos);
        sql.setString(4, id_Usuarios);
                
        sql.executeUpdate();
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR..(."+ex.getMessage());
        }
    }
    public void Buscar(String Emp_Documento)
    {
       
     try
     {
       conn.Conectar();
       sql=conn.con.prepareStatement("select *from empleados  where Emp_Documento=?");
       sql.setString(1, Emp_Documento);
       sql.executeQuery();
       datos=sql.getResultSet();     
     }
    catch(Exception ex)
    {
      System.out.println("ERROR AL BUSCAR DATOS...");
    }
    }
    public void Modificar_empleado(String  Emp_Documento, String Emp_Nombres, String Emp_Apellidos, String id_Usuarios)
{
try{
   conn.Conectar();
   sql=conn.con.prepareStatement ("UPDATE empleados SET Emp_Nombres=?, Emp_Apellidos=? WHERE Emp_Documento=?");
   sql.setString(1, Emp_Nombres);
   sql.setString(2, Emp_Apellidos);
   sql.setString(3, Emp_Documento);
   sql.setString(4, id_Usuarios);

   int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ACTUALIZADOS CORRECTAMENTE ","Empleados",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR","Empleados",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
}
    public void Eliminar(String Emp_Documento)
    {
       try
       {
        conn.Conectar();
        sql= conn.con.prepareStatement("DELETE  FROM empleados WHERE Emp_Documento=?");
        sql.setString(1, Emp_Documento);
        
        int respuesta=sql.executeUpdate();
    if(respuesta>0)
    {
        JOptionPane.showMessageDialog(null," DATOS ELIMINADOS CORRECTAMENTE ","Empleado",JOptionPane.INFORMATION_MESSAGE );
    }
    else
    {
        JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR","Empleado",JOptionPane.ERROR_MESSAGE);
    }
    conn.cerrar();    
    }
catch(SQLException ErrMod)
{
    conn.cerrar();
    System.out.print("Error al modificar"+ErrMod.getMessage());
} 
    }  
    
public void listar_combo_usuario(){
  
   try{
             conn.Conectar();
             sql=conn.con.prepareStatement("select * from usuarios");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
public void listar_usuario(String Usu_username){
 
   try{
    conn.Conectar();
    sql=conn.con.prepareStatement("select * from usarios where Usu_username=?");
    sql.setString(1, Usu_username);
    sql.executeQuery();
    datos=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
 }
    
}
