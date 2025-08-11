// ListaBitacora.java
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class BitacoraCitas {

    private NodoBitacora cabeza;

    public BitacoraCitas() {
        cabeza = null;
    }

    /**
     * Inserta un nuevo nodo en la lista enlazada de forma ordenada según la
     * cédula. La lista se mantiene ordenada alfabéticamente por la cédula.
     *
     */
    public void insertar(NodoBitacora nuevo) {
        if (cabeza == null || nuevo.getCedula().compareTo(cabeza.getCedula()) < 0) {
            // Insertar al inicio
            cabeza = nuevo;
        } else {
            NodoBitacora actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            // Inserta al final
            actual.setSiguiente(nuevo);
        }
    }

    /**
     * Verifica si la bitácora está vacía.
     *
     * @return true si está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Devuelve el nodo cabeza de la bitácora.
     *
     * @return NodoBitacora cabeza.
     */
    public NodoBitacora getCabeza() {
        return cabeza;
    }

    /**
     * Muestra la bitácora simple en un diálogo, con información básica de cada
     * cita. Si la bitácora está vacía, muestra un mensaje indicando que no hay
     * citas atendidas.
     */
    public void mostrarBitacoraSimple() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay citas atendidas hoy.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        NodoBitacora actual = cabeza;
        while (actual != null) {
            sb.append("Número de Ficha: ").append(actual.getNumeroFicha()).append("\n");
            sb.append("Fecha de Llegada: ").append(actual.getFechaLlegada().toString()).append("\n");
            sb.append("Fecha de Atención: ").append(actual.getFechaAtencion().toString()).append("\n");
            sb.append("Cédula: ").append(actual.getCedula()).append("\n");
            sb.append("Nombre: ").append(actual.getNombre()).append("\n");
            sb.append("-------------------------------\n");
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Bitácora de Citas del Día", JOptionPane.INFORMATION_MESSAGE);
    }
}
