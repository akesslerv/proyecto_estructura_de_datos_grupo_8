/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author EQUIPO
 */
public class ListaDobleCircular {
     private NodoDoble primero;
     private NodoDoble ultimo;

    public ListaDobleCircular() {
    }

    public ListaDobleCircular(NodoDoble primero, NodoDoble ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }
    
    
    public void insertaOrdenado(int identificador, String nombre){
       // X.1 Crear la cajita.
       NodoDoble aux = new NodoDoble(identificador, nombre);

       // Caso 1:  La lista está vacía.
       if (primero == null){
           primero = aux;
           ultimo = aux;
           ultimo.setSiguiente(primero);
           primero.setAnterior(ultimo);
       }else if (identificador < primero.getIdentificador()){
       // Caso 2: Cuando quiero insertar un elemento menor al primero
           aux.setSiguiente(primero);
           primero.setAnterior(aux);
           aux.setAnterior(ultimo);
           ultimo.setSiguiente(aux);
           primero = aux;
       }
       
       // Caso 4: Cuando quiero insertar en el medio.
       else{
           NodoDoble temp = primero;
           while (temp.getSiguiente().getIdentificador() < identificador){
               temp = temp.getSiguiente();
           }
       
       aux.setSiguiente(temp.getSiguiente());
       temp.setSiguiente(aux);
       aux.setAnterior(temp);
       aux.getSiguiente().setAnterior(aux);
           
       }
    }
    
}
