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
    private String codigo;
    private String nombre;
    private NodoArbol nodoDer;
    private NodoArbol nodoIzq;
    ListaPreguntas listaPreguntas;
    
    //Constructores
    public NodoArbol() {
    }
    
    public NodoArbol(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaPreguntas = new ListaPreguntas();
    }
    
    //Getters & Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ListaPreguntas getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ListaPreguntas listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    //Objeto en formato String
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}