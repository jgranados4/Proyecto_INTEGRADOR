//package Frames;
//public class ColaPrioridad {
//   
//    // Implementando cola con prioridad
//    //usando listas enlazadas	
//    // Nodo 
//    static class Nodo { 
//	Vehiculo dato; 	
//	// Lower values indicate higher priority 
//	int prioridad; 	
//	Nodo siguiente; 	
//    } 
//    static int size=0;
//    static Nodo nodo = new Nodo(); 
//    
//    // Fucion para crear un nuevo nodo
//    static Nodo newNodo(Vehiculo dato, int prioridad) 
//    { 
//	Nodo temp = new Nodo(); 
//	temp.dato = dato; 
//	temp.prioridad = prioridad; 
//	temp.siguiente = null; 
//	size++;
//	return temp; 
//    } 
//	
//   // Retorna el valor de la cabeza
//    static Vehiculo peek(Nodo cabeza) 
//    { 
//	return (cabeza).dato; 
//    } 
//	
//    // Elimina ls elementos
//    // con prioridad mayor
//    static Nodo pop(Nodo cabeza) 
//    { 
//	Nodo temp = cabeza; 
//	(cabeza) = (cabeza).siguiente; 
//	return cabeza; 
//    } 
//	
//    // Funcion para insertar segun prioridad
//    static Nodo push(Nodo cabeza, Vehiculo dato, int prioridad) 
//    { 
//	Nodo empieza = (cabeza); // Crea un nuevo nodo	
//	Nodo temp = newNodo(dato, prioridad); 	
//	// Special Case: The head of list has lesser 
//	// priority than new node. So insert new 
//	// node before head node and change head node. 
//	if ((cabeza).prioridad > prioridad) { 
//	
//		// Inserta NEW NODO antes del nodo cabeza
//		temp.siguiente = cabeza; 
//		(cabeza) = temp; 
//	} 
//	else { 
//	
//		// Recorre la lista buscando una
//		// posicion para insertar el nodo
//		while (empieza.siguiente!= null && 
//			empieza.siguiente.prioridad < prioridad) { 
//			empieza = empieza.siguiente; 
//		} 
//	
//		// Si al final de la lista 
//		// o segun la posicion requerida
//		temp.siguiente = empieza.siguiente; 
//		empieza.siguiente = temp; 
//	} 
//	return cabeza; 
//    } 
//	
//    // Funcion que indica si la lista esta vacia
//    static int isEmpty(Nodo cabeza) 
//    { 
//	return ((cabeza) == null)?1:0; 
//    } 
//    public static int size(){
//        return size;
//    }
//} 
//
//
//
