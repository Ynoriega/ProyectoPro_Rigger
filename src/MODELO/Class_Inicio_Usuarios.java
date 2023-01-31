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
 * @author JHON SANCHEZ YEISON NORIEGA ADSI 600128
 */
public class Class_Inicio_Usuarios {
	/* creamos una instancia de la clase conexion */
	CONTROLADOR.Class_CONEXION conn = new CONTROLADOR.Class_CONEXION();

	public PreparedStatement sql;// TRABAJO CON SQL
	public ResultSet datos;// TRABAJO BASE DE DATOS

	public void inicio_sesion(String Usu_username, String Usu_password) {
		try {

			conn.Conectar();
			sql = conn.con.prepareStatement("SELECT * FROM usuarios WHERE Usu_username='" + Usu_username
					+ "' AND Usu_password='" + Usu_password + "'");

			sql.executeQuery();
			datos = sql.getResultSet();

		} catch (Exception ex) {
			System.out.println("USUARIO O CONTRASEÑA INCORRECTA...");
		}
	}

}