/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Clase que representa un nodo de queja en la pila de quejas. Contiene la
 * información del paciente que abandonó la cola sin ser atendido.
 */
public class NodoQueja {

    private final String nombre;
    private final String cedula;
    private final String ficha;
    private final Timestamp fechaHora;
    private String razonQueja;
    private NodoQueja siguiente;

    public NodoQueja(String nombre, String cedula, String ficha, String razonQueja) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ficha = ficha;
        this.fechaHora = Timestamp.valueOf(LocalDateTime.now());
        this.razonQueja = (razonQueja != null && !razonQueja.trim().isEmpty()) ? razonQueja.trim() : "No especificada";
        this.siguiente = null;
    }
    /**
     * Solicita al usuario que ingrese la razón de la queja mediante un cuadro
     * de diálogo. Si no se ingresa una razón válida, se asigna "No
     * especificada".
     *
     * @return La razon de la queja
     */

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

    public String getRazonQueja() {
        return razonQueja;  // Devuelve la razón de la queja
    }
    
    public void setRazonQueja(String razonQueja) {
    this.razonQueja = (razonQueja != null && !razonQueja.trim().isEmpty()) ? razonQueja.trim() : "No especificada";
}

    // Setters
    public void setSiguiente(NodoQueja siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Solicita al usuario la razón de abandono de la cola.
     * Si el usuario cancela o deja vacío, se asigna "No especificada".
     *
     * @return Razón ingresada
     */
    private String pedirRazon() {
        String razon = JOptionPane.showInputDialog("Ingrese la razón por la que abandona la cola:");
        return (razon != null && !razon.trim().isEmpty()) ? razon.trim() : "No especificada";
    }

    /**
     * Devuelve la fecha y hora del abandono de la cola con formato(dd/MM/yyyy HH:mm:ss).
     * 
     * @return 
     */
    public String getFechaHoraFormateada() {
        // Formato de fecha: dd/MM/yyyy HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHora.toLocalDateTime().format(formatter);
    }
}