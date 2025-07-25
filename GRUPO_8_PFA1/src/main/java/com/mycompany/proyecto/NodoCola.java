package com.mycompany.proyecto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que representa un nodo en una cola de pacientes. Contiene información
 * personal y de control como el nombre, cédula, número de ficha, fecha de
 * creación y enlace al siguiente nodo.
 */
public class NodoCola {

    private String nombre;
    private String cedula;
    private String numeroFicha;
    private Timestamp fecha;
    private NodoCola siguiente;

    public NodoCola() {
    }

    public NodoCola(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha = Timestamp.valueOf(LocalDateTime.now());
    }

    public NodoCola(String nombre, String cedula, String numeroFicha) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroFicha = numeroFicha;
        this.fecha = Timestamp.valueOf(LocalDateTime.now());
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ficha: " + numeroFicha 
                + ", Nombre: " + nombre 
                + ", Cédula: " + cedula 
                + ", Fecha: " + fecha;
    }

}
