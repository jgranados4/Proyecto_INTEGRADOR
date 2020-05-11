/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


/**
 *
 * @author usuario
 */
public class Jfrm_Principal extends javax.swing.JFrame {
    static int puestos_autos = 30;
    static int puestos_motos = 10;
    
    public Jfrm_Principal() {
        initComponents();       
        pnel_Ingresar.setEnabled(false);
        tarea.run();
        tiempo.schedule(tarea, 0, 1);
        lblCarros.setText(Integer.toString(30-new dao.daoVehiculos().CuantosVehiculos("Auto")));
        lblMoto.setText(Integer.toString(10-new dao.daoVehiculos().CuantosVehiculos("Motocicleta")));
        
        setLocationRelativeTo(null);
        if (arduino_esta_conectado.equals("")) {
            ConectarArduino();   //Metodo comentado para conexion al arduino
        }
    }
    
    static String arduino_esta_conectado = "";
    static String dato;
    static String boton = "false";
    static int entrada_1 = 0;
    static int entrada_2 = 0;
    static int entrada_3 = 0;
    static int entrada_4 = 0;
    
    static PanamaHitek_Arduino ino=new PanamaHitek_Arduino();
    SerialPortEventListener listender = new SerialPortEventListener() {//Interpreta cada vez que el monitor serial es actualizado
        @Override
        public void serialEvent(SerialPortEvent serialPortEvent) {
            try {
                if (ino.isMessageAvailable()) {
                    dato = ino.printMessage();
                    if (dato.equals("INGRESO_1") && entrada_1 == 1) {
                        boton = "true";
                    }
                    if (dato.equals("INGRESO_1") && entrada_1 == 0) {
                        entrada_1 = entrada_1 + 1;
                    }
                    
                    if (dato.equals("INGRESO_2") && entrada_2 == 1) {
                        boton = "true";
                    }
                    if (dato.equals("INGRESO_2") && entrada_2 == 0) {
                        entrada_2 = entrada_2 + 1;
                    }
                    
                    if (dato.equals("INGRESO_3") && entrada_3 == 1) {
                        boton = "true";
                    }
                    if (dato.equals("INGRESO_3") && entrada_3 == 0) {
                        entrada_3 = entrada_3 + 1;
                    }
                    
                    if (dato.equals("INGRESO_4") && entrada_4 == 1) {
                        boton = "true";
                    }
                    if (dato.equals("INGRESO_4") && entrada_4 == 0) {
                        entrada_4 = entrada_4 + 1;
                    }
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(Jfrm_Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(Jfrm_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    Timer tiempo = new Timer();
    
        TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            if (boton.equals("true")) {
                boton = "false";
                pnel_Ingresar.setEnabled(true);
            }
        }
    };
    
    public void ConectarArduino(){
        try {
            ino.arduinoRX("COM7", 9600, listender);
            arduino_esta_conectado = "true";
        } catch (ArduinoException ex) {
            Logger.getLogger(Jfrm_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Jfrm_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_car = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCarros = new javax.swing.JLabel();
        lblMoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnel_Ingresar = new java.awt.Button();
        pnel_Listar = new java.awt.Button();
        pnel_Retirar = new java.awt.Button();
        pnel_Salir = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 49, 101));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Parking MR Goku");

        lbl_car.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/parqueadero.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" AUTOS de 30:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" MOTOS de 10:");

        lblCarros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCarros.setForeground(new java.awt.Color(255, 255, 255));

        lblMoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMoto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parqueos Disponibles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(lbl_car, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbl_car)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnel_Ingresar.setBackground(new java.awt.Color(27, 49, 101));
        pnel_Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        pnel_Ingresar.setLabel("Ingresar Vehiculo");
        pnel_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnel_IngresarActionPerformed(evt);
            }
        });

        pnel_Listar.setActionCommand("Listar Vehiculo");
        pnel_Listar.setBackground(new java.awt.Color(27, 49, 101));
        pnel_Listar.setForeground(new java.awt.Color(255, 255, 255));
        pnel_Listar.setLabel("Listar Vehiculo");
        pnel_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnel_ListarActionPerformed(evt);
            }
        });

        pnel_Retirar.setActionCommand("Retirar Vehiculo");
        pnel_Retirar.setBackground(new java.awt.Color(27, 49, 101));
        pnel_Retirar.setForeground(new java.awt.Color(255, 255, 255));
        pnel_Retirar.setLabel("Retirar Vehiculo");
        pnel_Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnel_RetirarActionPerformed(evt);
            }
        });

        pnel_Salir.setActionCommand("Salir");
        pnel_Salir.setBackground(new java.awt.Color(27, 49, 101));
        pnel_Salir.setForeground(new java.awt.Color(255, 255, 255));
        pnel_Salir.setLabel("Salir");
        pnel_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnel_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnel_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnel_Listar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnel_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnel_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnel_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnel_Listar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnel_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnel_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnel_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnel_IngresarActionPerformed
        Jfrm_Ingresar abrir = new Jfrm_Ingresar();
        
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnel_IngresarActionPerformed

    private void pnel_RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnel_RetirarActionPerformed
        Jfrm_Salida salida = new Jfrm_Salida();
        
        salida.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_pnel_RetirarActionPerformed

    private void pnel_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnel_ListarActionPerformed
        Jfrm_Listar abrir = new Jfrm_Listar();
        
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnel_ListarActionPerformed

    private void pnel_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnel_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_pnel_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jfrm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jfrm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jfrm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jfrm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jfrm_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCarros;
    private javax.swing.JLabel lblMoto;
    private javax.swing.JLabel lbl_car;
    private java.awt.Button pnel_Ingresar;
    private java.awt.Button pnel_Listar;
    private java.awt.Button pnel_Retirar;
    private java.awt.Button pnel_Salir;
    // End of variables declaration//GEN-END:variables
}
