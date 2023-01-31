/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Class_CONEXION {

	public PreparedStatement sql; // TRABAJO EN SENTENCIAS DE SQL
	public ResultSet datos; // TRAER DATOS DE LA BD
	public Connection con = null; // CONEXIÓN A LA BASE DE DATOS
	private String server;
	private String port;
	private String user;
	private String pass;

	public Class_CONEXION() {
		try {
			String valor2;
			String valor3;
			String valor4;
			String valor5;
			FileReader f = new FileReader(System.getProperty("user.dir") + "\\server.config");
			BufferedReader b = new BufferedReader(f);
			while ((valor2 = b.readLine()) != null) {
				this.server = valor2;

			}
			b.close();
			FileReader g = new FileReader(System.getProperty("user.dir") + "\\port.config");
			BufferedReader d = new BufferedReader(g);
			while ((valor3 = d.readLine()) != null) {
				this.port = valor3;
			}
			d.close();
			FileReader h = new FileReader(System.getProperty("user.dir") + "\\config1.config");
			BufferedReader c = new BufferedReader(h);
			while ((valor3 = c.readLine()) != null) {
				this.user = valor3;

			}
			h.close();
			FileReader i = new FileReader(System.getProperty("user.dir") + "\\config2.config");
			BufferedReader e = new BufferedReader(i);
			while ((valor4 = e.readLine()) != null) {
				this.pass = valor4;
			}
			d.close();

		} catch (IOException e) {

		}

	}

	public void Conectar() {

		String db = "jdbc:mysql://" + this.server + ":" + this.port + "/pro_rigger"; // "jdbc:MotorBaseDeDatos://localhost:3306/NombreBaseDeDatos"
		System.out.println(db);
		String usuario = this.user;
		String password = this.pass;
		try {
			String controlador = "com.mysql.jdbc.Driver";
			System.out.println("ESTABLECIENDO ENLACE CON BASE DE DATOS..." + db);
			Class.forName(controlador);
			con = DriverManager.getConnection(db, usuario, password);
			System.out.println("CONEXION EXITOSA ");

		} catch (Exception ex) {
			System.out.println("Error " + db + usuario + password + "\n" + ex.getMessage());
			JOptionPane.showMessageDialog(null, "Datos de conexión incorectos");
		}

	}

	public void cerrar() {

		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
			}
		}

	}

}
