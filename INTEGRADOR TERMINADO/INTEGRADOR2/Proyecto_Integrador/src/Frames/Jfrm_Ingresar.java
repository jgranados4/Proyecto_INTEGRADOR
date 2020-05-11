/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import dao.Conexion;
import dao.daoVehiculos;
import entidades.Vehiculo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author usuario
 */
public class Jfrm_Ingresar extends javax.swing.JFrame {

    ListasEnlazadas<VehiculosLE> lst = new ListasEnlazadas();

    public Jfrm_Ingresar() {
        initComponents();
        setLocationRelativeTo(null);

        Fecha(); //Fecha del sistema
        Hora(); // Hora del sistema
    }

    void Fecha() {
        Date Fecha_sistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        lbl_fecha.setText(formato.format(Fecha_sistema));
    }

    void Hora() {
        Timer tiempo = new Timer(1000, new Jfrm_Ingresar.horas());
        tiempo.start();
    }

    class horas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Date sistHora = new Date();
            String pmAM = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAM);
            Calendar hoy = Calendar.getInstance();
            lbl_hora.setText(String.format(format.format(sistHora), hoy));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipo_Vehiculo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_placaLetras = new javax.swing.JTextField();
        rbAuto = new javax.swing.JRadioButton();
        rbMoto = new javax.swing.JRadioButton();
        btn_registrar = new javax.swing.JButton();
        txt_placaNumeros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(148, 224, 227));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ingreso de vehiculos al parqueadero");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Placa:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Tipo de Vehiculo");

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

        Tipo_Vehiculo.add(rbAuto);
        rbAuto.setText("Auto");

        Tipo_Vehiculo.add(rbMoto);
        rbMoto.setText("Motocicleta");

        btn_registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ingresar.png"))); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("-");

        jLabel6.setText("Hora");

        jLabel7.setText("Fecha");

        lbl_hora.setText("HORA");

        lbl_fecha.setText("FECHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_registrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbAuto)
                                        .addGap(61, 61, 61)
                                        .addComponent(rbMoto))
                                    .addComponent(jLabel3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_placaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9)
                                .addComponent(txt_placaNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_fecha, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(lbl_hora))))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(24, 24, 24))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_placaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_placaNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_hora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbl_fecha))))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMoto)
                    .addComponent(rbAuto))
                .addGap(18, 18, 18)
                .addComponent(btn_registrar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Connection con;

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // String placa,fecha,hora,tipo;  

        String placa = txt_placaLetras.getText() + txt_placaNumeros.getText();

        if (txt_placaLetras.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Llene el campo letras porfabor");
            txt_placaLetras.requestFocus();

        } else if (txt_placaNumeros.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Llene el campo numeros porfabor");
            txt_placaNumeros.requestFocus();

        } else if (!(rbAuto.isSelected() || rbMoto.isSelected())) {
            Toolkit.getDefaultToolkit().beep(); //Sonido de mensaje de error 
            JOptionPane.showMessageDialog(null, "Tipo de Vehiculo no selecionado", "Mensaje de advertencia", JOptionPane.INFORMATION_MESSAGE);

        } else if (new daoVehiculos().siExisteDato(placa) == true) {
            Toolkit.getDefaultToolkit().beep(); //Sonido de mensaje de error 
            JOptionPane.showMessageDialog(null, "La placa " + placa + " ya existe");
            txt_placaLetras.setText("");
            txt_placaNumeros.setText("");
            Tipo_Vehiculo.clearSelection();

        } else {
            try {
                Thread hilo = new Thread() {
                    public void run() {
                        Vehiculo dato = new Vehiculo();
                        dato.setPlaca(txt_placaLetras.getText() + "-" + txt_placaNumeros.getText());
                        dato.setFecha(lbl_fecha.getText());
                        dato.setHora(lbl_hora.getText());

                        if (rbAuto.isSelected()) {
                            dato.setTipo("Auto");
                        } else if (rbMoto.isSelected()) {
                            dato.setTipo("Motocicleta");
                        }

                        if (new daoVehiculos().Insertar(dato)) {
                            JOptionPane.showMessageDialog(null, "GUARDADO");
                            txt_placaLetras.setText("");
                            txt_placaNumeros.setText("");
                            Tipo_Vehiculo.clearSelection();


                        } else {
                            JOptionPane.showMessageDialog(null, "NO GUARDADO");
                            txt_placaLetras.setText("");
                            txt_placaNumeros.setText("");
                            Tipo_Vehiculo.clearSelection();
                        }

                    }
                };
                hilo.start();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, x);
            }
        }
        
                                    Jfrm_Principal abrir = new Jfrm_Principal();
                            abrir.setVisible(true);
                            this.dispose();
    }//GEN-LAST:event_btn_registrarActionPerformed


    private void txt_placaLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaLetrasKeyTyped
        // TODO add your handling code here:
        char Placa = evt.getKeyChar();
        if (!((Placa >= 65 && Placa <= 95) || (Placa >= 97 && Placa <= 122)) & (Placa != 8)) {
            evt.consume(); //Cancela la tecla precionada
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Caracter no valido");
        }

        int cantidad = txt_placaLetras.getText().trim().length();
        if (cantidad >= 3) { // solo 3 letras el 4to da error
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        ///// para convertir letras miniusculas a mayusculas
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Tipo_Vehiculo;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JTextField txt_placaLetras;
    private javax.swing.JTextField txt_placaNumeros;
    // End of variables declaration//GEN-END:variables
}