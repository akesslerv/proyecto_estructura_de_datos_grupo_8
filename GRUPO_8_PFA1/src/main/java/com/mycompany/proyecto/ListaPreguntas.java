/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Grupo 8
 */
public class ListaPreguntas {
    
    //Atributo
    private Pregunta cabeza;
    
    //Getter & Setter
    public Pregunta getCabeza() {
        return cabeza;
    }

    public void setCabeza(Pregunta cabeza) {
        this.cabeza = cabeza;
    }
    
    //Metodos
    public void agregarPregunta(String codigo, String nombre, String respuesta) {
        Pregunta nueva = new Pregunta(codigo, nombre, respuesta);
        if (cabeza == null) {
            cabeza = nueva;
        } else {
            Pregunta temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nueva);
        }
    }

    public Pregunta buscarPregunta(String codigo) {
        Pregunta temp = cabeza;
        while (temp != null) {
            if (temp.getCodigo().equals(codigo)) return temp;
            temp = temp.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPregunta(String codigo) {
        if (cabeza == null) return false;

        if (cabeza.getCodigo().equals(codigo)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Pregunta temp = cabeza;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getCodigo().equals(codigo)) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}