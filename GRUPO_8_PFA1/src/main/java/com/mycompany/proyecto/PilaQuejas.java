/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class PilaQuejas {

    private NodoQueja tope;

    public void apilar(String nombre, String cedula, String ficha) {
        NodoQueja nuevo = new NodoQueja(nombre, cedula, ficha);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

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
                    .append(aux.getFechaHora()).append("\n\n");
            aux = aux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public NodoQueja getTope() {
        return tope;
    }
}
