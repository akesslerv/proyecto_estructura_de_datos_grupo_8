/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;

public class Ayuda {
    public static void mostrarAyuda() {
        String ayuda = """
        ===== AYUDA DEL SISTEMA =====

        Este sistema permite gestionar la llegada y atención de pacientes.
        Opciones disponibles en el submenú de atención:

        0 - Seleccionar ficha:
            Registra un paciente en la cola de espera del sistema.

        1 - Atender paciente:
            Atiende al siguiente paciente, según prioridad (preferencial o regular).

        2 - Abandonar cola:
            Permite que un paciente salga de la fila y registre una queja opcional.

        3 - Mostrar fichas pendientes:
            Muestra los pacientes aún en espera en ambas colas.

        4 - Ver quejas recibidas:
            Lista todas las quejas registradas por los pacientes.

        5 - Salir:
            Cierra el submenú de atención y regresa al menú principal.

        Nota: La atención prioriza la cola preferencial sobre la regular.
        """;

        JOptionPane.showMessageDialog(null, ayuda, "Ayuda del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}