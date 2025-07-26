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

    public boolean estaVacia() {
        return this.frente == null;

    }

    /**
     * Encola un nuevo paciente con sus datos.
     *
     * @param nombre Nombre del paciente
     * @param cedula Cédula del paciente
     * @param numeroFicha Ficha asignada (Ej: "P1", "R3")
     */
    public void encolar(String nombre, String cedula, String numeroFicha) {
        NodoCola nuevo = new NodoCola(nombre, cedula, numeroFicha);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        tamaño++;
    }

    /**
     * Elimina y retorna el primer nodo de la cola.
     *
     * @return NodoCola eliminado, o null si está vacía.
     */
    public NodoCola desencolar() {
        if (frente == null) {
            return null;
        }
        NodoCola nodoDesencolado = frente;
        frente = frente.getSiguiente();
        tamaño--;
        if (frente == null) {
            ultimo = null;
        }
        nodoDesencolado.setSiguiente(null);
        return nodoDesencolado;
    }

    /**
     * Calcula el tamaño real de la cola recorriéndola. Útil para validar el
     * contador interno.
     */
    public int tamañoCola() {
        int contador = 0;
        NodoCola aux = frente;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
}
