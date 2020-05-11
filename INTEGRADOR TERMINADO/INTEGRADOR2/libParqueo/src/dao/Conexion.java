/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kathy
 */
public class Conexion {
    public static Connection conectarMYSQL(){
        Connection conex=null;
        try {
            String strCon ="jdbc:mysql://localhost/bd_vehiculos";
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection(strCon,"root","");
        } catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return conex;
    }
}
