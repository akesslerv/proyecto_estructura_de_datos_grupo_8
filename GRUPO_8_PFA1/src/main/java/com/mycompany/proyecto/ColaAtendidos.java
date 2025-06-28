/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;

public class ColaAtendidos extends ColaPaciente {

    // Constructor 
    public ColaAtendidos() {
        super();
    }

    // Bitacora de citas
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
