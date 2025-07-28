/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;

/**
 * Clase que representa una lista circular simple de historial de citas médicas.
 * Cada nodo contiene información sobre la cédula del paciente, la fecha de la
 * cita, el doctor tratante y el diagnóstico emitido.
 *
 * La lista se mantiene ordenada por número de cédula en orden ascendente.
 *
 */
public class ListaHistoricoCitas {

    NodoHistoricoCitas cabeza;
    NodoHistoricoCitas ultimo;

    public ListaHistoricoCitas() {
        this.cabeza = cabeza;
        this.ultimo = ultimo;
    }

    /**
     * Inserta una nueva cita médica en la lista de forma ordenada por número de
     * cédula. Si la lista está vacía, la cita se convierte en el primer y
     * último nodo.
     *
     */
    public void insertarOrdenado(int cedula, Timestamp fecha, String doctor, String diagnostico) {
        NodoHistoricoCitas nuevo = new NodoHistoricoCitas(cedula, fecha, doctor, diagnostico);

        if (cabeza == null) {
            cabeza = nuevo;
            ultimo = nuevo;
            ultimo.siguiente = cabeza;
        } else if (cedula < cabeza.getCedula()) {
            //Insertar al inicio
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            ultimo.siguiente = cabeza;
        } else {
            //Buscar posición de inserción
            NodoHistoricoCitas actual = cabeza;
            while (actual.siguiente != cabeza && actual.siguiente.getCedula() < cedula) {
                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            if (actual == ultimo) {
                ultimo = nuevo;
            }
        }

    }

    /**
     * Verifica si la lista está vacía.
     *
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Retorna el historial de citas médicas de un paciente específico.
     *
     */
    public String mostrarHistorialCitas(int cedula) {
        NodoHistoricoCitas actual = cabeza;
        String texto = "";
        boolean encontrado = false;
        do {
            if (actual.getCedula() == cedula) {
                texto += "Fecha: " + actual.getFecha()
                        + "\nDoctor: " + actual.getDoctor()
                        + "\nDiagnóstico: " + actual.getDiagnostico()
                        + "\n";
                encontrado = true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        if (!encontrado) {
            texto += "No hay citas registradas para esta cédula.";
        }
        return texto;
    }

}
