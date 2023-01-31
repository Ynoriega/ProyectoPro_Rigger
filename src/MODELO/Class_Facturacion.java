

package MODELO;
import CONTROLADOR.Class_CONEXION;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class Class_Facturacion {
    
    CONTROLADOR.Class_CONEXION conn=new CONTROLADOR.Class_CONEXION();
    public PreparedStatement sql;//TRABAJAR CON SQL
    public ResultSet datos;// TRABAJAR BASE DE DATOS
   
   public  double dinero;
   public String servicios="";
   public String cedula;
   public String cliente;
   public String direccion;
   public String ciudad;
   public String telefono;
    // buscar información de la factura
    public void BuscarInfo(String veh_placa)
    {
        try
        {
         conn.Conectar();
       //validar la placa en las tablas
         sql=conn.con.prepareStatement("select * from `ingreso_taller` where id_recepcion_placa=?"  );
         sql.setString(1, veh_placa);
         sql.executeQuery();
         datos=sql.getResultSet();
         if(datos.next()){
         sql=conn.con.prepareStatement("select * from `reparacion` where id_info_diagnostico=?"  );
         sql.setString(1, veh_placa);
         sql.executeQuery();
         datos=sql.getResultSet();
         if(datos.next()){
         
         sql=conn.con.prepareStatement("select * from salida_taller where id_reparacion_placa=?"  );
         sql.setString(1, veh_placa);
         sql.executeQuery();
          datos=sql.getResultSet();
         if(datos.next()){
             
             //traer informacion de la cuatro tablas
      sql=conn.con.prepareStatement("SELECT cliente.`Cli_Documento` AS cliente_Cli_Documento,cliente.`Cli_nombre` AS cliente_Cli_nombre,cliente.`Cli_direccion` AS cliente_Cli_direccion,cliente.`Cli_ciudad` AS cliente_Cli_ciudad,cliente.`Cli_telefono` AS cliente_Cli_telefono,reparacion.`valor_servic` AS reparacion_valor_servic,reparacion.`info_servicio` AS reparacion_info_servicio FROM `cliente` cliente INNER JOIN `vehiculo` vehiculo ON cliente.`Cli_Documento` = vehiculo.`id_info_cliente` INNER JOIN `reparacion` reparacion ON vehiculo.`Veh_placa` = reparacion.`id_info_diagnostico`  where vehiculo.`Veh_placa`=?");
         sql.setString(1, veh_placa);
         sql.executeQuery();
          datos=sql.getResultSet();
     int x=1;
         
         while(datos.next()){
         dinero+=datos.getDouble(6);
         
         servicios+=x+") "+datos.getString(7)+"\n";
         cliente=datos.getString(2);
         telefono=datos.getString(5);
          direccion=datos.getString(3);
              ciudad=datos.getString(4);
                 cedula=datos.getString(1);
         x++;
         }
          
         }
         else{
         JOptionPane.showMessageDialog(null,"No se le ha dado salida al vehículo");
         }
         }
         else{
         JOptionPane.showMessageDialog(null, "El vehículo no ha sido asignado a servicios a través de reparación");
         
         }
         
         }
         else{
         JOptionPane.showMessageDialog(null, "El vehiculo no ha sido ingresado al taller");
         
         }
        }
        catch(SQLException ex)
        {
             System.out.println("ERROR AL BUSCAR DATOS..." + ex.getMessage());
        }
        conn.cerrar();
    }
    
    //generar un número de factura nuevo en base al ultimo número de fatura que esta registrado
    public int BuscarConsecutivoFactura()
    {
        int consecutivoFactura=0;
        try
        {
         conn.Conectar();
       
         sql=conn.con.prepareStatement("select max(id_Factura) from factura"  );
        
         sql.executeQuery();
         datos=sql.getResultSet();
         if(datos.next()){
         
         consecutivoFactura=datos.getInt(1);
         }
          conn.cerrar();
        }
        catch(SQLException ex)
        {
             System.out.println("ERROR AL BUSCAR DATOS..." + ex.getMessage());
              conn.cerrar();
        }
       
        return consecutivoFactura+1;
    }
    
     public double BuscarSubtotal(String placa)
    {
        double consecutivoFactura=0;
        try
        {
         conn.Conectar();
       
         sql=conn.con.prepareStatement("select sum(valor_servic) from reparacion where id_info_diagnostico='"+placa+"'"  );
        
         sql.executeQuery();
         datos=sql.getResultSet();
         if(datos.next()){
         
         consecutivoFactura=datos.getDouble(1);
         }
          conn.cerrar();
        }
        catch(SQLException ex)
        {
             System.out.println("ERROR AL BUSCAR DATOS..." + ex.getMessage());
              conn.cerrar();
        }
       
        return consecutivoFactura;
    }
    
    
    
    
//    public void Buscar(int Cli_Documento)
//    {
//       
//     try
//     {
//       conn.Conectar();
//       sql=conn.con.prepareStatement("select * from Cliente  where Cli_Documento=?");
//       sql.setInt(1, Cli_Documento);
//       sql.executeQuery();
//       datos=sql.getResultSet();     
//     }
//    catch(SQLException ex)
//    {
//      System.out.println("ERROR AL BUSCAR DATOS..."+ex.getMessage());
//    }
//    conn.cerrar();
//    }
}
