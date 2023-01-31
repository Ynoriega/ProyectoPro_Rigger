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
public class ClassRegistroMarcaServicio {
    
    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS
 
    
    public void GuardarMarca(String nom_marcavh, String nom_marcamt)
    {
        try
        {
            conn.Conectar();
            sql=conn.con.prepareStatement("INSERT INTO `dbprorigger_garage`.`marcas` (nom_marcavh, nom_marcamt) VALUES (?,?);");
            sql.setString(1, nom_marcavh);
            sql.setString(2, nom_marcamt);
            sql.executeUpdate();
            conn.cerrar();
        }
        catch(Exception ex)
        {
            System.out.println("Error al Guardar  " + ex.getMessage());
            conn.cerrar();
        }
    }
    
    public void GuardarTipoServicio(String nom_servicio)
    {
        try
        {
            conn.Conectar();
            sql=conn.con.prepareStatement("INSERT INTO `dbprorigger_garage`.`tipo_servicio` (nom_servicio) VALUES (?)");
            sql.setString(1, nom_servicio);
            sql.executeUpdate();
            conn.Conectar();
        }  
        catch(Exception ex)
        {
            System.out.println("Error al Guardar  " + ex.getMessage());
            conn.cerrar();
        }
    }
    
    public void GuardarClaseVehiculo(String nom_clase)
    {
        try
        {
            conn.Conectar();
            sql=conn.con.prepareStatement("INSERT INTO `dbprorigger_garage`.`tipo_vehiculos` (nom_clase) VALUES (?)");
            sql.setString(1, nom_clase);
            sql.executeUpdate();
            conn.Conectar();
        }
        catch(Exception ex)
        {
            System.out.println("Error al Guardar  " + ex.getMessage());
            conn.cerrar();
        }
    }
}
