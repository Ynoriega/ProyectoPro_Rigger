/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.ClassCostoServicio;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON SANCHEZ
 *         YEISON NORIEGA 
 *         ADSI 600128
 */
public class JInternalFrame_TipoServicio_y_Costo extends javax.swing.JInternalFrame {
    
    MODELO.ClassCostoServicio conn = new MODELO.ClassCostoServicio();
    ClassCostoServicio obj = new ClassCostoServicio();

    /**
     * Creates new form JInternalFrame_TipoServicio_y_Costo
     */
    public JInternalFrame_TipoServicio_y_Costo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nomServicio = new javax.swing.JTextField();
        txt_costoServicio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Registrar tipo de servicio y costo");

        jLabel2.setText("Servicio");

        jLabel3.setText("Costo");

        txt_nomServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nomServicioKeyTyped(evt);
            }
        });

        txt_costoServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costoServicioKeyTyped(evt);
            }
        });

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_costoServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txt_nomServicio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(txt_nomServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(txt_costoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.Guardar();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nomServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomServicioKeyTyped
       char c = evt.getKeyChar();

        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'!' || c>'.')
            && (c!=(char)KeyEvent.VK_SPACE))
        {
            evt.consume();//CODIGO PARA INGRESAR SOLO LETRAS
        } 
        else if(Character.isLowerCase(c))//CODIGO PARA FORZAR LA MAYUSCULAS
        {
            String cadena = (""+c).toUpperCase();
            c=cadena.charAt(0);
            evt.setKeyChar(c);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomServicioKeyTyped

    private void txt_costoServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoServicioKeyTyped
      
        char c = evt.getKeyChar();
        if(c<'0' || c>'9')
        {
            getToolkit().beep();
            evt.consume();//CODIGO PARA INGRESAR SOLO NUMEROS
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoServicioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_costoServicio;
    private javax.swing.JTextField txt_nomServicio;
    // End of variables declaration//GEN-END:variables

    public void Guardar()
    {
        try
        {
        obj.GuardarServicioYcosto(txt_nomServicio.getText(), Double.parseDouble(txt_costoServicio.getText()));
        JOptionPane.showMessageDialog(null,"DATOS ALMACENADOS CORRECTAMENTE","GUARDAR",JOptionPane.INFORMATION_MESSAGE);
        this.Limpiar();
        }
        catch(Exception ex)
        {
           System.out.println("Error " + ex.getMessage()); 
        }
    }

    public void Limpiar()
    {
        txt_nomServicio.setText("");
        txt_costoServicio.setText("");
    }
}
