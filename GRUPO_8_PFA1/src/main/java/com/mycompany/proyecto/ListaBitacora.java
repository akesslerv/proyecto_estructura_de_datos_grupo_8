// ListaBitacora.java
package com.mycompany.proyecto;

import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ListaBitacora {
    private NodoBitacora cabeza;

    public ListaBitacora() {
        this.cabeza = null;
    }

    // Inserta ordenado por cédula (ascendente)
    public void insertarOrdenado(NodoBitacora nuevo) {
        if (cabeza == null || nuevo.getCedula().compareTo(cabeza.getCedula()) < 0) {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
            return;
        }
        NodoBitacora actual = cabeza;
        while (actual.getSiguiente() != null &&
               actual.getSiguiente().getCedula().compareTo(nuevo.getCedula()) < 0) {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
    }

    // Mostrar la bitácora completa
    public void mostrarBitacora() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay registros en la bitácora.");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder("Bitácora de Citas del Día:\n\n");
        NodoBitacora aux = cabeza;
        while (aux != null) {
            sb.append("Ficha: ").append(aux.getNumeroFicha())
              .append(" | Nombre: ").append(aux.getNombre())
              .append(" | Cédula: ").append(aux.getCedula())
              .append("\nLlegada: ").append(sdf.format(aux.getFechaLlegada()))
              .append("\nAtención: ").append(sdf.format(aux.getFechaAtencion()))
              .append("\n\n");
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}