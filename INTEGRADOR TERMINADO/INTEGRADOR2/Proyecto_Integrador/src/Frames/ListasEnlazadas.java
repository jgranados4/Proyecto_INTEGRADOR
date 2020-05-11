/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import javax.swing.JOptionPane;

/**
 *
 * @author Janeth
 */
public class ListasEnlazadas<VehiculosLE> {
    Nodo primero;
    Nodo ultimo;
    public void listaVacia() {
        primero = null;
    }
    
    public void insertarPrimero(VehiculosLE v){
        Nodo <VehiculosLE> nuevo= new Nodo<>(v);
        if(!siVacio()){
            nuevo.setNodoDer(primero);
        }
        primero=nuevo;
    }
    
    public void insertarUltimo(VehiculosLE v){
        Nodo <VehiculosLE> aux= new Nodo<>(v);
        Nodo <VehiculosLE>rec_aux;
        if(siVacio()){
            insertarPrimero(v);
        }else{
            rec_aux=primero;
            while(rec_aux.getNodoDer()!=null){
                rec_aux=rec_aux.getNodoDer();
            }
            rec_aux.setNodoDer(aux);
        }
        
        
    }
    
    public boolean siVacio(){
        return(this.primero==null);
    }
    
    
    public String toString(){
        String contenido="";
        Nodo<VehiculosLE> aux=primero;
        while(aux!=null){
            contenido+=aux.getDato()+"\n";
            aux = aux.getNodoDer();
        }
        
        return contenido;
    }
   
    public int cuantosElementos(){
        Nodo <VehiculosLE> aux;
        int numElementos=0;
        aux=primero;
        while(aux!=null){
            numElementos++;
            aux=aux.getNodoDer();
        }
        return numElementos;
    }
    public VehiculosLE devolverDato(int pos){
        Nodo <VehiculosLE>aux = primero;
        int cont =0;
        VehiculosLE dato = null;
        if(pos < 0 || pos >= cuantosElementos()){
            JOptionPane.showMessageDialog(null, "La posicion insertada no es correcta");
         }else{
            while (aux!=null){
             if(pos == cont){
                 dato = aux.getDato();
             }
             aux = aux.getNodoDer();
                 cont++;
         }
        }
        return dato;
    }
     public Nodo <VehiculosLE> devolverNodo(int pos){
        Nodo<VehiculosLE> aux=primero;
        int cont=0;
        if (pos < 0 || pos >= cuantosElementos()){
           JOptionPane.showMessageDialog(null, "JANETH");
        }else{
            while(aux!=null){
                if(pos == cont ){
                    return aux;
                }
                aux = aux.getNodoDer();
                cont++;
            }
        }
        return aux;
    }
     public void mostrar(){
        Nodo <VehiculosLE> aux=primero;
        while(aux!=null){
            System.out.println(aux.getDato());
            aux=aux.getNodoDer();
        }
        
    }
}
