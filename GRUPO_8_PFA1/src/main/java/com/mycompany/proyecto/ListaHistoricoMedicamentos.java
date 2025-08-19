/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;

/**
 * @author GRUPO 8
 * Clase que representa una lista circular enlazada de históricos de
 * medicamentos. Cada nodo contiene información sobre la cédula del paciente, la
 * fecha de prescripción y los medicamentos asignados.
 *
 * La lista se mantiene ordenada por cédula.
 *
 */
public class ListaHistoricoMedicamentos {

    NodoHistoricoMedicamentos cabeza;
    NodoHistoricoMedicamentos ultimo;

    public ListaHistoricoMedicamentos() {
    }

    /**
     * Inserta un nuevo nodo con la información de medicamentos de forma
     * ordenada según la cédula del paciente. Si la lista está vacía, lo agrega
     * como primer nodo.
     *
     */
    public void insertarOrdenado(int cedula, Timestamp fecha, String medicamentos) {
        NodoHistoricoMedicamentos nuevo = new NodoHistoricoMedicamentos(cedula, fecha, medicamentos);

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
            NodoHistoricoMedicamentos actual = cabeza;
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
     * Retorna una cadena con el historial de medicamentos de un paciente, 
     * recorriendo la lista hasta encontrar todos los registros con la cédula especificada.
     * 
     */
    public String HistoricoMedicamentos(int cedula) {
        NodoHistoricoMedicamentos actual = cabeza;
        StringBuilder cadena = new StringBuilder();

        while (actual != null) {
            if (actual.getCedula() == cedula) {
                Timestamp fecha = actual.getFecha();
                String medicamentos = actual.getMedicamentos();

                cadena.append("Fecha: ").append(fecha).append(" Medicamentos: ").append(medicamentos).append("\n");
            }
            actual = actual.siguiente;
        }

        return cadena.toString();
    }
    
     /**
     * Muestra todos los registros de medicamentos para una cédula específica,
     * recorriendo la lista circular desde el inicio.
     * 
     */
    public String mostrarHistorialMedicamentos(int cedula) {
        NodoHistoricoMedicamentos actual = cabeza;
        String texto = "";
        boolean encontrado = false;
        do {
            if (actual.getCedula() == cedula) {
                texto += "Fecha: " + actual.getFecha()
                        + "\nMedicamentos: " + actual.getMedicamentos()
                        + "\n";
                encontrado = true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        if (!encontrado) {
            texto += "No hay medicamentos registrados para esta cédula.";
        }
        return texto;
    }
}
