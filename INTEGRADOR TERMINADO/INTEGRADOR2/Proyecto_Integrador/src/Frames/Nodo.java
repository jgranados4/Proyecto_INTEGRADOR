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
public class Nodo<Vehiculo> {
    private Nodo <Vehiculo> nodoDer;
    private Vehiculo dato;
    
            
    public Nodo(){
        nodoDer=null;
        
    }
    public Nodo (Vehiculo d){
        dato=d;
        nodoDer=null;
        
    }
    public Nodo (Vehiculo d,Nodo n){
        dato=d;
        nodoDer=n;
        
    }
    
    public Nodo getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }
    
    
}
