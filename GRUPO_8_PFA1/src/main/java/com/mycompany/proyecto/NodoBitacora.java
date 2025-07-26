/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.sql.Timestamp;

/**
 * Clase que representa un nodo en la lista de bitácora de citas.
 * Cada nodo almacena información sobre una cita de un paciente, incluyendo
 * número de ficha, fechas de llegada y atención, cédula y nombre del paciente,
 * así como una referencia al siguiente nodo en la lista.
 */

public class NodoBitacora {

    private String numeroFicha;
    private Timestamp fechaLlegada;   // timestamp en milisegundos
    private Timestamp fechaAtencion;  // timestamp en milisegundos
    private String cedula;
    private String nombre;
    private NodoBitacora siguiente;

    public NodoBitacora(String numeroFicha, Timestamp fechaLlegada, Timestamp fechaAtencion, String cedula, String nombre) {
        this.numeroFicha = numeroFicha;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
        this.cedula = cedula;
        this.nombre = nombre;
        this.siguiente = null;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Timestamp getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Timestamp fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Timestamp getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Timestamp fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }

}
