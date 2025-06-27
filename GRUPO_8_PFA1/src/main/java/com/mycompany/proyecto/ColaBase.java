package com.mycompany.proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EQUIPO
 */
public class ColaBase {

    private NodoCola frente;    // Referencia al primer elemento de la cola. Sirve para sacar elementos.
    private NodoCola ultimo;    // Referencia al último elemento de la cola. Sirve para insertar elemento.
    private int tamaño;
            
    public ColaBase() {
        frente = null;      // Inicializar la referencia al primero en nulo.
        ultimo = null; // Inicializar la referencia al último en nulo.
        tamaño = 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    public NodoCola getFrente() {
        return frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean estaVacia(){
        return this.frente == null;
        
    }
    
    // Método que inserta elementos en la cola.
    public void encolar(int dato){
        // Paso 1: Crear el nuevo Nodo.
        NodoCola aux = new NodoCola();
        
        // Me ubico en el último elemento y le establezco el sgte con el nuevo 
        // nodo
        // Paso 2: Amarrar el nuevo nodo a la cola.
        if (this.estaVacia()){
            //this.frente = aux;
            this.setFrente(aux);
        }
        else{
           this.getUltimo().setSiguiente(aux);  
           // En este caso el frente NO es relevante. 
        }
        // Paso 3: Establecer el nuevo nodo como último de la cola.
        this.setUltimo(aux);  // Muevo la referencia del último al nuevo último.
        this.tamaño++;
    }
    
    public NodoCola desencolar () {
        if (this.estaVacia()){
            // No puedo desencolar debo retornar error.
            return null;
        }
        else{
            // Paso 1: Guardar el primer elemento en una variable temporal.
            NodoCola aux = new NodoCola();
            aux = this.getFrente();
            // Paso 2: Muevo el frente al que está de segundo en la cola.
            this.frente = this.frente.getSiguiente();
            
            // Si solo tenía un elemento, entonces tanto frente como ultimo deben quedar
            // en null.
            if (this.frente == null)
               this.ultimo = null; 
            
            tamaño = tamaño - 1; 
            
            // Simplemente como vamos a retornar el aux, lo desligo del resto de la cola.
            aux.setSiguiente(null);
            return aux;
        }
    }
    
    public int tamañoCola(){
        NodoCola aux = this.frente;
        int contador = 0;
        while (aux != null){
            contador = contador + 1;
            aux = aux.getSiguiente();
        }
        return contador;
    }    
}

