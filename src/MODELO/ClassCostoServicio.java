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
public class ClassCostoServicio {
    
        CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos,rs;// TRABAJAR BASE DE DATOS
    
    
    public void GuardarServicioYcosto(String nom_servicio, Double pre_servicio)
    {
        try
        {
        conn.Conectar();
        sql=conn.con.prepareStatement("INSERT INTO `dbprorigger_garage`.`servicios` (nom_servicio, pre_servicio) VALUES (?,?);");
        sql.setString(1, nom_servicio);
        sql.setDouble(2, pre_servicio);
        sql.executeUpdate();
        conn.cerrar();
        }
        catch(SQLException ex)
        {
            System.out.println("Error al Guardar  " + ex.getMessage());
            conn.cerrar();
        }
    }
}
