/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;


/**
 * Clase que muestra una ventana con la ayuda del sistema, datos de version y
 * autores del sistema.
 */

public class Ayuda {

    public static void mostrarAyuda() {
        String ayuda = """
                🏥 Hospital Su Salud - Sistema de Gestión de Pacientes
            
                Este sistema permite gestionar la llegada y atención de pacientes.
                Opciones disponibles en el submenú de atención:
                        
                0 - Seleccionar ficha:
                    Registra un paciente en la cola de espera del sistema
                        
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
                        
                Versión: 1.0.0
                
                Autores:
                • Jousteen José Cordero Valerio
                <jcordero60060@ufide.ac.cr>
                • Alessandra Barbara Kessler Valdivia
                <akessler70010@ufide.ac.cr>
                • Dilan Adolfo Palacio Artiles
                <dpalacio18910@ufide.ac.cr>
                • Emely Tatiana Sellis Alegría
                <esellis91302@ufide.ac.cr>
                
                """;

        JOptionPane.showMessageDialog(null, ayuda, "Ayuda del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}