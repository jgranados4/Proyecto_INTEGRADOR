/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kathy
 */
public class daoVehiculos {

    public int CuantosVehiculos(String moto_O_carro) {
        int suma = 0;
        try {
            Connection conex = Conexion.conectarMYSQL();

            String sql = "SELECT * FROM tbl_vehiculo WHERE vh_tipo = '" + moto_O_carro + "' ";
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                suma++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return suma;
    }

    DateFormat dateFormat_Fecha_hora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    DateFormat dateFormat_fecha = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

    public boolean Insertar(Vehiculo obj) {

        String Fecha_de_ingreso;
        String Hora_de_ingreso;

        boolean band = false;

        try {
            Connection conex = Conexion.conectarMYSQL();
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();

            Fecha_de_ingreso = dateFormat_fecha.format(date);
            Hora_de_ingreso = dateFormat_hora.format(date);

            String sql = "INSERT INTO tbl_vehiculo"
                    + "(vh_placa,vh_fecha,vh_hora,vh_tipo)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, obj.getPlaca());
            ps.setString(2, Fecha_de_ingreso);
            ps.setString(3, Hora_de_ingreso);
            ps.setString(4, obj.getTipo());
            ps.executeUpdate();
            band = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
        return band;
    }

    public void Listar(DefaultTableModel tabla) {

        try {
            Connection conex = Conexion.conectarMYSQL();
            String sql = "SELECT * FROM tbl_vehiculo";
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            tabla.getDataVector().clear();
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("vh_placa");
                row[1] = rs.getString("vh_fecha");
                row[2] = rs.getString("vh_hora");
                row[3] = rs.getString("vh_tipo");
                tabla.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean siExisteDato(String placa) {
        boolean existe = false;
        try {
            Connection conex = Conexion.conectarMYSQL();

            String sql = "SELECT * FROM tbl_vehiculo WHERE vh_placa = '" + placa + "'";
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("vh_placa") != null) {
                    existe = true;
                } else {
                    existe = false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return existe;
    }

    public int TiempoTranscurrido(String placa) {
        int tiempoTranscurrido = 0;
        try {
            Connection conex = Conexion.conectarMYSQL();
            String sql = "SELECT * FROM tbl_vehiculo WHERE vh_placa = '" + placa + "'";
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String getTime_fecha_hora = rs.getString("vh_fecha") + " " + rs.getString("vh_hora");
                
                java.util.Date Fecha_Hora_Ingreso = dateFormat_Fecha_hora.parse(getTime_fecha_hora); ////
   
                Calendar cal = Calendar.getInstance();
                java.util.Date date = cal.getTime();

                tiempoTranscurrido = (int) (date.getTime() - Fecha_Hora_Ingreso.getTime()) / 60000;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tiempoTranscurrido;
    }

    public double TotalPagar(String placa) {
        double Total = 0.25;
        try {
            Connection conex = Conexion.conectarMYSQL();
            String sql = "SELECT * FROM tbl_vehiculo WHERE vh_placa = '" + placa + "'";
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                String getTime_fecha_hora = rs.getString("vh_fecha") + " " + rs.getString("vh_hora");
                
                java.util.Date Fecha_Hora_Ingreso = dateFormat_Fecha_hora.parse(getTime_fecha_hora);

                Calendar cal = Calendar.getInstance();
                java.util.Date date = cal.getTime();

                int minutos_cobrar = (int) (date.getTime() - Fecha_Hora_Ingreso.getTime()) / 60000;
                
                if (minutos_cobrar < 15) {
                    Total = (double) 0.25;
                } else if (minutos_cobrar >= 15) {
                    minutos_cobrar = minutos_cobrar / 15;
                    Total = (double) (minutos_cobrar * 0.25);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Total;
    }

    public void Eliminar(String Placa) {

        try {
            Connection conex = Conexion.conectarMYSQL();
            String sql = "DELETE FROM tbl_vehiculo"
                    + " WHERE vh_placa"
                    + " = '" + Placa + "'";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    
    public String getHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }

    public String getFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
        return date;
    }
}
