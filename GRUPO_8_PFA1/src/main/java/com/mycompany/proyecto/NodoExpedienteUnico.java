/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.sql.Timestamp;

/**
 * Clase que representa un nodo en una lista doblemente enlazada circular 
 * utilizada para gestionar el expediente único de un paciente en el sistema hospitalario.
 * 
 * Cada nodo contiene los datos personales del paciente y la fecha de creación 
 * del expediente, además de referencias al nodo siguiente y anterior.
 * 
 * Esta estructura permite navegar en ambos sentidos de forma circular.
 *  */
public class NodoExpedienteUnico {
    
    private int cedula, edad;
    private String nombre, genero;
    private Timestamp fecha;
    NodoExpedienteUnico siguiente, anterior;
    
    
    
    public NodoExpedienteUnico(int cedula, String nombre, int edad, String genero, Timestamp fecha)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.fecha = fecha;
        this.siguiente = this;
        this.anterior = this;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public NodoExpedienteUnico getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoExpedienteUnico siguiente) {
        this.siguiente = siguiente;
    }

    public NodoExpedienteUnico getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoExpedienteUnico anterior) {
        this.anterior = anterior;
    }
    
    
    
    
}
