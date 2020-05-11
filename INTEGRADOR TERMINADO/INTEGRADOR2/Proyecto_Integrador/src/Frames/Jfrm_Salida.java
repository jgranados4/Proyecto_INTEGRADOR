/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.Conexion;
import dao.daoVehiculos;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Janeth
 */
public class Jfrm_Salida extends javax.swing.JFrame {

    /**
     * Creates new form Jfrm_Salida
     */
    DefaultTableModel tabla;
    ListasEnlazadas<VehiculosLE> lstE = new ListasEnlazadas<>();   
    public Jfrm_Salida() {
        String cabecera []= {"Fecha","Placa","Tipo","Hora entrada","Hora de salida","Pago"};       
        tabla=new DefaultTableModel(cabecera,0);
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Cerrar = new javax.swing.JButton();
        btn_Retiro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblPermanencia = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        btnBuscarPlaca = new javax.swing.JButton();
        txt_placaLetras = new javax.swing.JTextField();
        txt_placaNumeros = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPDFRS = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Salidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        btn_Retiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btn_Retiro.setText("Retirar Vehiculo");
        btn_Retiro.setEnabled(false);
        btn_Retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RetiroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tiempo de permanencia:");

        btnBuscarPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarPlaca.setText("BUSCAR PLACA");
        btnBuscarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlacaActionPerformed(evt);
            }
        });

        txt_placaLetras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_placaLetrasFocusLost(evt);
            }
        });
        txt_placaLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaLetrasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaLetrasKeyTyped(evt);
            }
        });

        txt_placaNumeros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_placaNumerosFocusLost(evt);
            }
        });
        txt_placaNumeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaNumerosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaNumerosKeyTyped(evt);
            }
        });

        jLabel1.setText("Letras");

        jLabel2.setText("Numeros");

        jLabel4.setText("-");

        btnPDFRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pdf.png"))); // NOI18N
        btnPDFRS.setText("PDF REGISTRO DE SALIDAS");
        btnPDFRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFRSActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Total a pagar:");

        jLabel6.setText("MINUTOS");

        jTable1.setModel(tabla);
        jScrollPane1.setViewportView(jTable1);

        btn_Salidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        btn_Salidas.setText("Mostrar salidas");
        btn_Salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_placaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_placaNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnBuscarPlaca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btn_Retiro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(lblPermanencia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnPDFRS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cerrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Salidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_placaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_placaNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPermanencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5))
                            .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btn_Retiro)
                        .addGap(18, 18, 18)
                        .addComponent(btnPDFRS, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_Salidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cerrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        // TODO add your handling code here:
        Jfrm_Principal abrir = new Jfrm_Principal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_CerrarActionPerformed
    Nodo<VehiculosLE>nd = new Nodo<>();
void deDB_a_LE(){
    try{       
        String sql = "SELECT * FROM tbl_vehiculo_salidas";
        Connection conex = Conexion.conectarMYSQL();
        PreparedStatement ps = conex.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();       
        while (rs.next()) {  
                VehiculosLE vh = new VehiculosLE();
                vh.setTipo(rs.getString("tipo"));             
                vh.setPlaca(rs.getString("placa"));
                vh.setFecha(rs.getString("fecha"));
                vh.setHoraE(rs.getString("hora_entrada"));
                vh.setHoraS(rs.getString("hora_salida"));
                vh.setPago(rs.getString("pago")); 
                lstE.insertarPrimero(vh);   
        }  
        conex.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
    }
    
}
    private void btn_RetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetiroActionPerformed

        String placa = txt_placaLetras.getText() + "-" + txt_placaNumeros.getText();

        if (txt_placaLetras.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo letras porfabor");
            txt_placaLetras.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        } else if (txt_placaLetras.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo numeros porfabor");
            txt_placaNumeros.requestFocus();
        } else {
            try {

                if (new dao.daoVehiculos().siExisteDato(placa) == true) {
                   //Conexion TBL_VEHICULO_SALIDAS
                    String sqle = "INSERT INTO tbl_vehiculo_salidas"
                            + "(fecha,tipo,placa,hora_entrada,hora_salida,pago)"
                            + "VALUES (?,?,?,?,?,?)";                    
                    Connection con = Conexion.conectarMYSQL();
                    PreparedStatement pst = con.prepareStatement(sqle);
                    
                    
                    //Conexion TBL_VEHICULO_ENTRADAS
                    String sql = "SELECT * FROM tbl_vehiculo WHERE vh_placa LIKE '%" + placa + "%'";
                    Connection conex = Conexion.conectarMYSQL();
                    PreparedStatement ps = conex.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        pst.setString(1, new daoVehiculos().getFecha());
                        pst.setString(2, rs.getString("vh_tipo"));
                        pst.setString(3, rs.getString("vh_placa"));
                        pst.setString(4, rs.getString("vh_hora"));
                        pst.setString(5, new daoVehiculos().getHora());
                        pst.setString(6,new daoVehiculos().TotalPagar(placa)+"");
                        pst.executeUpdate();
                        
                    }
                    new daoVehiculos().Eliminar(placa); ///
                    
                    JOptionPane.showMessageDialog(null, "PLACA RETIRADA CON EXITO");
                    txt_placaLetras.setText("");
                    txt_placaNumeros.setText("");
                    txt_placaLetras.requestFocus();                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Placa no existe \nNo se puede retirar");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
        }


    }//GEN-LAST:event_btn_RetiroActionPerformed

    private void btnBuscarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlacaActionPerformed

        String placa = txt_placaLetras.getText() + "-" + txt_placaNumeros.getText();

        if (!(txt_placaLetras.getText().isEmpty() || txt_placaNumeros.getText().isEmpty())) {

            if (new daoVehiculos().siExisteDato(placa) == true) {
                
                JOptionPane.showMessageDialog(null, "PLACA ENCONTRADA");
                
                lblPermanencia.setText(Integer.toString(new daoVehiculos().TiempoTranscurrido(placa)));
                lblTotalPagar.setText(new daoVehiculos().TotalPagar(placa)+"");
                
                btn_Retiro.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "PLACA NO EXISTE");
                txt_placaLetras.setText("");
                txt_placaNumeros.setText("");
                txt_placaLetras.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta escribir el numero de placa");
            txt_placaLetras.setText("");
            txt_placaNumeros.setText("");
            txt_placaLetras.requestFocus();
        }


    }//GEN-LAST:event_btnBuscarPlacaActionPerformed
void mostrarenTabla(){ 
            deDB_a_LE();
            tabla.getDataVector().clear();
            Nodo<VehiculosLE> ndT;
            VehiculosLE vhT;  
            Object row[]=new Object[6];            
            for (int i = 0; i < lstE.cuantosElementos(); i++) {   
                
                ndT=lstE.devolverNodo(i);               
                vhT=ndT.getDato();
                row[0]=vhT.getFecha();
                row[1]=vhT.getPlaca();
                row[2]=vhT.getTipo();
                row[3]=vhT.getHoraE();
                row[4]=vhT.getHoraS();
                row[5]=vhT.getPago(); 
                tabla.addRow(row);
            }
    }
    private void btnPDFRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFRSActionPerformed
        lstE.listaVacia();
        deDB_a_LE();
        Nodo<VehiculosLE> nds = new Nodo<>();
        VehiculosLE vhs = new VehiculosLE();
        try {
            Document documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/REPORTE_SALIDA_DE_VEHICULOS.pdf"));
            documento.open();
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("PARKING MR.GOKU "));
            documento.add(new Paragraph("                                                 Reporte de Salidas"));
            documento.add(new Paragraph(new daoVehiculos().getFecha()));
            documento.add(new Paragraph(new daoVehiculos().getHora()));
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Placa");
            tabla.addCell("Fecha ");
            tabla.addCell("Hora entrada");
            tabla.addCell("Hora salida");
            tabla.addCell("Tipo");
            tabla.addCell("Total a Pagar");   
            tabla.setHeaderRows(1);
            for (int i = 0; i <lstE.cuantosElementos(); i++) {                
                nds = lstE.devolverNodo(i);
                vhs = nds.getDato();
                tabla.addCell(vhs.getPlaca());
                tabla.addCell(vhs.getFecha());
                tabla.addCell(vhs.getHoraE());
                tabla.addCell(vhs.getHoraS());
                tabla.addCell(vhs.getTipo());
                tabla.addCell(vhs.getPago());                
            }
            documento.add(tabla);                
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero PDF SALIDAS en el ESCRITORIO");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnPDFRSActionPerformed
 
    private void txt_placaLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaLetrasKeyTyped
        // TODO add your handling code here:
        char Placa = evt.getKeyChar();
        if (!((Placa >= 65 && Placa <= 95) || (Placa >= 97 && Placa <= 122)) & (Placa != 8)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Caracter no valido");
        }
        
        int cantidad = txt_placaLetras.getText().trim().length();
        if (cantidad >= 3) { // solo 3 letras el 4to da error
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        char placa_letra = evt.getKeyChar();  
        if (Character.isLowerCase(placa_letra)) {
            String cad = ("" + placa_letra).toUpperCase();
            placa_letra = cad.charAt(0);
            evt.setKeyChar(placa_letra);
        }
    }//GEN-LAST:event_txt_placaLetrasKeyTyped
 
    private void txt_placaNumerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaNumerosKeyTyped

        int c = evt.getKeyChar();
        //         0          9      delete    
        if ((c >= 48 && c <= 58) || (c == 8)) {
        } else {
            evt.consume(); //Cancela la tecla precionada
            Toolkit.getDefaultToolkit().beep(); //Sonido de mensaje de error  
            JOptionPane.showMessageDialog(null, "Caracter no valido");
        }

        int cantidad = txt_placaNumeros.getText().trim().length();
        if (cantidad >= 4) { // solo 4 numeros el 5 da error
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

    }//GEN-LAST:event_txt_placaNumerosKeyTyped

    private void txt_placaLetrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaLetrasKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown()) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ACCION NO VALIDA");
        }
    }//GEN-LAST:event_txt_placaLetrasKeyPressed

    private void txt_placaNumerosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaNumerosKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown()) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ACCION NO VALIDA");
        }
    }//GEN-LAST:event_txt_placaNumerosKeyPressed

    private void txt_placaLetrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_placaLetrasFocusLost

        int c = txt_placaLetras.getText().trim().length(); //trip es para que no cuente si dejo espacio al inicio.
        // El método de length de cadena devuelve la cantidad de caracteres escritos en la Cadena.

        if (c >= 1 && c <= 2) { //si la placa es 1 o 2 da error
            Toolkit.getDefaultToolkit().beep(); //Sonido de mensaje de error   
            JOptionPane.showMessageDialog(null, "Rango de placa no valido", "Mensaje de advertencia", JOptionPane.INFORMATION_MESSAGE);
            txt_placaLetras.setText("");
            txt_placaLetras.requestFocus();
        }
    }//GEN-LAST:event_txt_placaLetrasFocusLost

    private void txt_placaNumerosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_placaNumerosFocusLost
 
        int c = txt_placaNumeros.getText().trim().length(); //trip es para que no cuente si dejo espacio al inicio.
        // El método de length de cadena devuelve la cantidad de caracteres escritos en la Cadena.

        if (c >= 1 && c <= 2) { //si la placa es 1 o 2 da error
            Toolkit.getDefaultToolkit().beep(); //Sonido de mensaje de error   
            JOptionPane.showMessageDialog(null, "Rango de placa no valido", "Mensaje de advertencia", JOptionPane.INFORMATION_MESSAGE);
            txt_placaNumeros.setText("");
            txt_placaNumeros.requestFocus();
        }
    }//GEN-LAST:event_txt_placaNumerosFocusLost

    private void btn_SalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalidasActionPerformed
        lstE.listaVacia();
        mostrarenTabla();
    }//GEN-LAST:event_btn_SalidasActionPerformed

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPlaca;
    private javax.swing.JButton btnPDFRS;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JButton btn_Retiro;
    private javax.swing.JButton btn_Salidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPermanencia;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JTextField txt_placaLetras;
    private javax.swing.JTextField txt_placaNumeros;
    // End of variables declaration//GEN-END:variables

}
