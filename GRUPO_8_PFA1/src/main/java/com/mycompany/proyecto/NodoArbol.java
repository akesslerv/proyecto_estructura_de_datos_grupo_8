/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Grupo 8
 */
public class NodoArbol {
    
    //Atributos
    private int dato;
    private NodoArbol nodoDer;
    private NodoArbol nodoIzq;
    
    //Constructores
    public NodoArbol() {
    }
    
    public NodoArbol(int dato) {
        this.dato = dato;
        this.nodoIzq = this.nodoDer = null;
    }
    
    //Getters & Setters
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }
}