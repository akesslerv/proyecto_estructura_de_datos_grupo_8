package com.mycompany.proyecto;

/**
 * Clase que representa una lista simple ordenada para almacenar nodos de bitácora
 * con información de citas de pacientes.
 */

public class ListaBitacora {

    private NodoBitacora cabeza;

    public ListaBitacora() {
        cabeza = null;
    }

    public NodoBitacora getCabeza() {
        return cabeza;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo nodo en la lista manteniendo el orden ascendente según la cédula del paciente.
     *
     * @param nuevo
     */
    public void insertarOrdenado(NodoBitacora nuevo) {
        if (cabeza == null || nuevo.getCedula().compareTo(cabeza.getCedula()) < 0) {
            // Insertar al inicio
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else {
            NodoBitacora actual = cabeza;
            while (actual.getSiguiente() != null
                    && actual.getSiguiente().getCedula().compareTo(nuevo.getCedula()) < 0) {
                actual = actual.getSiguiente();
            }
            // Insertar después de actual
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

    void mostrarBitacora() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
