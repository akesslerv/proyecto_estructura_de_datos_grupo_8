/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

public class NodoBitacora {
    private  String numeroFicha;
    private  long fechaLlegada;   // timestamp en milisegundos
    private  long fechaAtencion;  // timestamp en milisegundos
    private  String cedula;
    private  String nombre;
    private NodoBitacora siguiente;

    public NodoBitacora(String numeroFicha, long fechaLlegada, long fechaAtencion, String cedula, String nombre) {
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

    public long getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(long fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public long getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(long fechaAtencion) {
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