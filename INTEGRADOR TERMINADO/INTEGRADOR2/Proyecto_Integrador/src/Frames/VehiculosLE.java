/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;



/**
 *
 * @author Janeth
 */
public class VehiculosLE {
        
                   
    String id,placa,fecha,horaE,horaS,tipo,pago;   

    public VehiculosLE() {
    }
    
    public VehiculosLE(String id, String placa, String fecha, String horaE, String horaS, String tipo, String pago) {
        this.id = id;
        this.placa = placa;
        this.fecha = fecha;
        this.horaE = horaE;
        this.horaS = horaS;
        this.tipo = tipo;
        this.pago = pago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }

    public String getHoraS() {
        return horaS;
    }

    public void setHoraS(String horaS) {
        this.horaS = horaS;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    

    
    
}
