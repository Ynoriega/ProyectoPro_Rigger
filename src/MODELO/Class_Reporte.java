/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import CONTROLADOR.Class_CONEXION;
import MODELO.Class_Facturacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Reporte {
    CONTROLADOR.Class_CONEXION clscon= new Class_CONEXION();
    MODELO.Class_Facturacion clsfac= new Class_Facturacion();
    
    public void reporteCliente() throws JRException,SQLException{
        try {

            
String reportName = System.getProperty("user.dir")+"\\reporte\\reportClientes";
JasperCompileManager.compileReportToFile(reportName + ".jrxml");
 
   clscon.Conectar();
JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper",null, clscon.con);
JasperViewer jviewer=new JasperViewer(print,false);
            jviewer.setTitle("");
            jviewer.setVisible(true); 
		} catch (Exception e) {
			System.out.print("No es posible generar el reporte");
                        System.out.print(e.getMessage());
		
		}
    } 
    public void reporteVehiculos() throws JRException,SQLException{
      
         try {

            
String reportName = System.getProperty("user.dir")+"\\reporte\\reportVehiculos";
JasperCompileManager.compileReportToFile(reportName + ".jrxml");
 
   clscon.Conectar();
JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper",null, clscon.con);
JasperViewer jviewer=new JasperViewer(print,false);
            jviewer.setTitle("");
            jviewer.setVisible(true);
/**
JRExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here			
exporter.exportReport();
         JOptionPane.showMessageDialog(null,"El reporte ha sido generado");
         abrirPDF(reportName + ".pdf");
**/
 
		} catch (Exception e) {
			System.out.print("No es posible generar el reporte");
                        System.out.print(e.getMessage());
		
		}
    } 
    
    public void reporteFactura(String placa) throws JRException,SQLException{
         try {

            
String reportName = System.getProperty("user.dir")+"\\reporte\\factura";
JasperCompileManager.compileReportToFile(reportName + ".jrxml");
 Map parametros = new HashMap();
 parametros.put("placa",placa);
 double diner=clsfac.BuscarSubtotal(placa);
 double iva=diner * 0.16;
 double total=diner + iva;
 //JOptionPane.showMessageDialog(null,"-"+diner+"-"+iva+"-"+total);
  parametros.put("valor", ""+diner);
   parametros.put("valor2", ""+total);
    parametros.put("valor3", ""+iva);
   clscon.Conectar();
JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper", parametros, clscon.con);
JasperViewer jviewer=new JasperViewer(print,false);
            jviewer.setTitle("");
            jviewer.setVisible(true);
/**
JRExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here			
exporter.exportReport();
         JOptionPane.showMessageDialog(null,"El reporte ha sido generado");
         abrirPDF(reportName + ".pdf");
**/
 
		} catch (Exception e) {
			System.out.print("No es posible generar el reporte");
                        System.out.print(e.getMessage());
		
		}
    } 
    
    
   

}
