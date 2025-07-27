/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import static com.mycompany.proyecto.Proyecto.ColaAtendidos;
import static com.mycompany.proyecto.Proyecto.ColaPreferencial;
import static com.mycompany.proyecto.Proyecto.ColaRegular;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Clase que representa a un paciente dentro del sistema del hospital. Gestiona
 * los datos del paciente, el proceso de atención según prioridad, y mantiene
 * una bitácora de pacientes que han sido atendidos.
 *
 */
public class Paciente {

    private final String nombre;
    private final String cedula;
    private final String numeroFicha;
    private static final ArrayList<Paciente> bitacoraAtendidos = new ArrayList<>();
    private static int contadorPreferenciales = 0;

    public Paciente(String nombre, String cedula, String numeroFicha) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroFicha = numeroFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void mostrarAviso() {
        JOptionPane.showMessageDialog(null,
                "Ficha #" + numeroFicha
                + " con cedula " + cedula
                + " pasar a consulta medica.");
    }

    /**
     * Atiende al siguiente paciente en la cola, siguiendo la regla: dos
     * preferenciales por uno regular. Si hay pacientes atendidos, se agregan a
     * la bitácora y a la cola de pacientes atendidos.
     */
    public static void atenderPaciente() {
        if (ColaPreferencial.estaVacia() && ColaRegular.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera.");
            return;
        }
        NodoCola nodo = null;
        if (contadorPreferenciales < 2 && !ColaPreferencial.estaVacia()) {
            nodo = ColaPreferencial.desencolar();
            contadorPreferenciales++;
        } else if (!ColaRegular.estaVacia()) {
            nodo = ColaRegular.desencolar();
            contadorPreferenciales = 0;
        } else if (!ColaPreferencial.estaVacia()) {
            nodo = ColaPreferencial.desencolar();
            contadorPreferenciales = Math.min(contadorPreferenciales + 1, 2);
        }
        if (nodo != null) {
            Paciente paciente = new Paciente(nodo.getNombre(), nodo.getCedula(), nodo.getNumeroFicha());
            paciente.mostrarAviso();
            Timestamp fechaExpediente = new Timestamp(System.currentTimeMillis());
            Proyecto.expedienteUnico.ingresarExpedienteUnico(Integer.parseInt(paciente.getCedula()), paciente.getNombre(), fechaExpediente);
            bitacoraAtendidos.add(paciente);
            String prefijo = paciente.getNumeroFicha().substring(0, 1);
            ColaAtendidos.encolar(prefijo, paciente.getNombre(), paciente.getCedula());

            // Aquí registras la bitácora
            Timestamp fechaLlegada = nodo.getFecha(); // ya es Timestamp
            Timestamp fechaAtencion = new Timestamp(System.currentTimeMillis());

            NodoBitacora nodoBitacora = new NodoBitacora(
                    paciente.getNumeroFicha(),
                    fechaLlegada,
                    fechaAtencion,
                    paciente.getCedula(),
                    paciente.getNombre()
            );

            Proyecto.bitacoraCitas.insertarOrdenado(nodoBitacora);
        }
    }
    
    /**
     * Muestra todos los pacientes que han sido atendidos hasta el momento,
     * listados desde el más antiguo hasta el más reciente.
     */
    public static void mostrarBitacora() {
        if (bitacoraAtendidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes atendidos aún.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Paciente p : bitacoraAtendidos) {
            sb.append("Ficha: ").append(p.getNumeroFicha())
                    .append(" | Nombre: ").append(p.getNombre())
                    .append(" | Cédula: ").append(p.getCedula())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Bitácora de Pacientes Atendidos", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Solicita al usuario una cédula y muestra todos los registros en la
     * bitácora correspondientes a esa cédula. Si no se encuentran
     * coincidencias, se notifica al usuario.
     */
    public static void mostrarBitacoraPorCedula() {
        if (bitacoraAtendidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes atendidos aún.");
            return;
        }

        String cedulaBuscada = JOptionPane.showInputDialog("Ingrese la cédula del paciente:");
        if (cedulaBuscada == null || cedulaBuscada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cédula no ingresada.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Paciente p : bitacoraAtendidos) {
            if (p.getCedula().equalsIgnoreCase(cedulaBuscada.trim())) {
                sb.append("Ficha: ").append(p.getNumeroFicha())
                        .append(" | Nombre: ").append(p.getNombre())
                        .append(" | Cédula: ").append(p.getCedula())
                        .append("\n");
            }
        }

        if (sb.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con esa cédula.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString(), "Bitácora del Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void mostrarFichasPendientes() {
        StringBuilder sb = new StringBuilder();

        if (ColaPreferencial.estaVacia() && ColaRegular.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay fichas pendientes.");
            return;
        }

        sb.append(" Fichas Preferenciales Pendientes:\n\n");
        NodoCola actual = ColaPreferencial.getFrente();
        while (actual != null) {
            sb.append("Ficha: ").append(actual.getNumeroFicha())
                    .append(" | Nombre: ").append(actual.getNombre())
                    .append(" | Cédula: ").append(actual.getCedula())
                    .append(" | Fecha: ").append(actual.getFecha()).append("\n");
            actual = actual.getSiguiente();
        }

        sb.append("\n Fichas Regulares Pendientes:\n\n");
        actual = ColaRegular.getFrente();
        while (actual != null) {
            sb.append("Ficha: ").append(actual.getNumeroFicha())
                    .append(" | Nombre: ").append(actual.getNombre())
                    .append(" | Cédula: ").append(actual.getCedula())
                    .append(" | Fecha: ").append(actual.getFecha()).append("\n");
            actual = actual.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Fichas Pendientes", JOptionPane.INFORMATION_MESSAGE);
    }
}
