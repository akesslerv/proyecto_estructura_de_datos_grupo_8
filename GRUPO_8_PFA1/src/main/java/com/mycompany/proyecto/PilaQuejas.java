/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 * Clase que representa una pila de quejas de pacientes. Almacena quejas de
 * pacientes que abandonaron la cola sin ser atendidos, utilizando una
 * estructura tipo pila (LIFO).
 */
public class PilaQuejas {

    private NodoQueja tope;

    /**
     * Apila una nueva queja en la pila.
     *
     * @param nombre
     * @param cedula
     * @param ficha
     */
    public void apilar(String nombre, String cedula, String ficha) {
        NodoQueja nuevo = new NodoQueja(nombre, cedula, ficha);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    /**
     * Muestra todas las quejas registradas en orden de abandono (último que
     * abandonó aparece primero). Si no hay quejas, se muestra un mensaje
     * correspondiente. Cada queja incluye ficha, cédula, fecha/hora y razón de
     * abandono.
     */
    public void imprimirQuejas() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay quejas registradas.");
            return;
        }

        NodoQueja aux = tope;
        StringBuilder sb = new StringBuilder("Quejas Recibidas:\n\n");

        while (aux != null) {
            sb.append("Ficha #").append(aux.getFicha())
                    .append(" con cédula ").append(aux.getCedula())
                    .append(" abandona la cola sin ser atendido(a) a la fecha y hora ")
                    .append(aux.getFechaHoraFormateada())
                    .append("\nRazón de la queja: ").append(aux.getRazonQueja())
                    .append("\n\n");
            aux = aux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Listado de Quejas", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public NodoQueja getTope() {
        return tope;
    }
}
