/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;

/**
 * Clase que representa la cola de pacientes ya atendidos.
 * Hereda de {ColaPaciente} y permite mostrar una bitácora completa
 * de los pacientes que pasaron por consulta.
 */

public class ColaAtendidos extends ColaPaciente {

    // Constructor 
    public ColaAtendidos() {
        super();
    }

    
    /**
     * Muestra una ventana con la bitácora completa de pacientes atendidos.
     *
     * Recorre toda la cola desde el frente hasta el final y muestra:
     * número de ficha, nombre, cédula y fecha de atención.
     */
   
    public void mostrarBitacoraCompleta() {
        NodoCola aux = this.getFrente();
        StringBuilder sb = new StringBuilder("Bitacora de Pacientes Atendidos:\n\n");

        while (aux != null) {
            sb.append("Ficha: ").append(aux.getNumeroFicha())
              .append("\nNombre: ").append(aux.getNombre())
              .append("\nCedula: ").append(aux.getCedula())
              .append("\nFecha: ").append(aux.getFecha())
              .append("\n-----------------------\n");

            aux = aux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}