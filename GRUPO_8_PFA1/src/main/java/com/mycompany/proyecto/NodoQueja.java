/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Clase que representa un nodo de queja en la pila de quejas.
 * Contiene la información del paciente que abandonó la cola sin ser atendido.
 */ 

public class NodoQueja {
    private String nombre;
    private String cedula;
    private String ficha;
    private Timestamp fechaHora;
    private NodoQueja siguiente;

    public NodoQueja(String nombre, String cedula, String ficha) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ficha = ficha;
        this.fechaHora = Timestamp.valueOf(LocalDateTime.now());
        this.siguiente = null;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFicha() {
        return ficha;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public NodoQueja getSiguiente() {
        return siguiente;
    }

    // Setters
    public void setSiguiente(NodoQueja siguiente) {
        this.siguiente = siguiente;
    }
    
}


