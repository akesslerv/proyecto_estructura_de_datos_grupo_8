/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import static com.mycompany.proyecto.Proyecto.ColaPreferencial;
import static com.mycompany.proyecto.Proyecto.ColaRegular;
import static com.mycompany.proyecto.Proyecto.ColaAtendidos;
import javax.swing.JOptionPane;

/**
 * Clase encargada de atender pacientes de acuerdo con la prioridad establecida.
 * Atiende primero hasta 2 pacientes preferenciales por cada paciente regular.
 */

public class AtenderPaciente {

    private static int ContadorPreferenciales;

    public static void atenderPaciente() {
        if (ColaPreferencial.estaVacia() && ColaRegular.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera.");
            return;
        }

        NodoCola pacienteAtendido = null;
        
        // Atender preferencial si se han atendido menos de 2 consecutivos
        if (ContadorPreferenciales < 2 && !ColaPreferencial.estaVacia()) {
            pacienteAtendido = ColaPreferencial.desencolar();
            ContadorPreferenciales++;
        // Si no se pudo atender preferencial y hay regular disponible
        } else if (!ColaRegular.estaVacia()) {
            pacienteAtendido = ColaRegular.desencolar();
            ContadorPreferenciales = 0;
        // Si no hay regular, seguir con preferenciales
        } else if (!ColaPreferencial.estaVacia()) {
            pacienteAtendido = ColaPreferencial.desencolar();
            ContadorPreferenciales = Math.min(ContadorPreferenciales + 1, 2);
        }
        // Mostrar información del paciente y agregar a la cola de atendidos
        if (pacienteAtendido != null) {
            JOptionPane.showMessageDialog(null,
                    "Ficha #" + pacienteAtendido.getNumeroFicha()
                    + " con cédula " + pacienteAtendido.getCedula()
                    + " pasar a consulta médica.");

            String prefijo = pacienteAtendido.getNumeroFicha().substring(0, 1);
            ColaAtendidos.encolar(prefijo, pacienteAtendido.getNombre(), pacienteAtendido.getCedula());
        }
    }

}
