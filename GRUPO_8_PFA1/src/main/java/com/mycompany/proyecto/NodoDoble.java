/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author EQUIPO
 */
public class NodoDoble {
    private int identificador;
    private String nombre;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public NodoDoble() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
}
