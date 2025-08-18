/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Grupo 8
 */
public class Pregunta{
    
    //Atributos
    private String codigo;
    private String nombre;
    private String respuesta;
    private Pregunta siguiente;
    
    
    //Constructores
    public Pregunta() {
    }

    public Pregunta(String codigo, String nombre, String respuesta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.respuesta = respuesta;
        this.siguiente = null;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Pregunta siguiente) {
        this.siguiente = siguiente;
    }
    
    //Objeto en formato String
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}