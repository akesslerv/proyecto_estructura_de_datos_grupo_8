/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * Clase que gestiona operaciones relacionadas con las colas de pacientes.
 * Incluye abandono de cola, visualización de fichas pendientes y quejas
 * recibidas.
 */
public class GestionColas {

    /**
     * Permite a un paciente abandonar la cola sin ser atendido.Si se encuentra
     * la ficha, se elimina de la cola correspondiente y se registra una queja.
     *
     * @param preferencial
     * @param regular
     * @param pila
     */
    public static void abandonarCola(ColaPaciente preferencial, ColaPaciente regular, PilaQuejas pila) {
        String fichaBuscar = Auxiliar.readString("Ingrese el número de ficha del paciente que desea abandonar la cola (Ej: R3 o P2)");
        // Validar cancelación o entrada vacía
        if (fichaBuscar == null || fichaBuscar.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o no se ingresó ninguna ficha.");
            return;  // Salir sin hacer nada
        }

        // Pedir la razón antes de eliminar
        String razon = pedirRazon();

        if (razon == null || razon.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una razón para abandonar la cola.");
            return;
        }

        boolean encontrado = eliminarDeCola(preferencial, fichaBuscar.trim(), pila, razon)
                || eliminarDeCola(regular, fichaBuscar.trim(), pila, razon);

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró la ficha " + fichaBuscar + " en ninguna cola.");
        }
    }

    /**
     * Elimina un paciente de la cola y registra la queja si coincide la ficha.
     */
    private static boolean eliminarDeCola(ColaPaciente cola, String ficha, PilaQuejas pila, String razon) {
        NodoCola actual = cola.getFrente();
        NodoCola anterior = null;
        while (actual != null) {
            if (actual.getNumeroFicha().equalsIgnoreCase(ficha)) {
                if (anterior == null) {
                    cola.setFrente(actual.getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                if (actual == cola.getUltimo()) {
                    cola.setUltimo(anterior);
                }
                cola.setTamaño(cola.getTamaño() - 1);
                JOptionPane.showMessageDialog(null,
                        "Ficha #" + actual.getNumeroFicha()
                        + " con cédula " + actual.getCedula()
                        + " abandona la cola sin ser atendido(a).");
                // Guardar la queja con la razón
                pila.apilar(actual.getNombre(), actual.getCedula(), actual.getNumeroFicha(), razon);
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Muestra una lista de todas las fichas pendientes en ambas colas
     * (preferencial y regular).
     *
     * @param preferencial
     * @param regular
     */
    public static void mostrarFichasPendientes(ColaPaciente preferencial, ColaPaciente regular) {
        StringBuilder sb = new StringBuilder("📋 Fichas Pendientes:\n\n");

        NodoCola aux = preferencial.getFrente();
        sb.append("Pacientes Preferenciales (Naranja):\n");
        while (aux != null) {
            sb.append(" - ").append(aux.getNumeroFicha())
                    .append(" | ").append(aux.getNombre()).append("\n");
            aux = aux.getSiguiente();
        }

        sb.append("\nPacientes Regulares (Verde):\n");
        aux = regular.getFrente();
        while (aux != null) {
            sb.append(" - ").append(aux.getNumeroFicha())
                    .append(" | ").append(aux.getNombre()).append("\n");
            aux = aux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /**
     * Muestra todas las quejas registradas por los pacientes que abandonaron la
     * cola.
     *
     * @param pila
     */
    public static void mostrarQuejasRecibidas(PilaQuejas pila) {
        if (pila.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay quejas registradas.");
            return;
        }
        NodoQueja aux = pila.getTope(); // Método que devuelve el nodo tope
        StringBuilder sb = new StringBuilder("Quejas Recibidas:\n\n");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (aux != null) {
            sb.append("Ficha #").append(aux.getFicha())
                    .append(" con cédula ").append(aux.getCedula())
                    .append(" abandona la cola sin ser atendido(a) a la fecha y hora ")
                    .append(formato.format(aux.getFechaHora())).append("\n")
                    .append("Razón: ").append(aux.getRazonQueja()).append("\n\n");
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static String pedirRazon() {
        return JOptionPane.showInputDialog(null,
                "Por favor, indique la razón por la que abandona la cola:",
                "Razón de Abandono",
                JOptionPane.QUESTION_MESSAGE);
    }
}
