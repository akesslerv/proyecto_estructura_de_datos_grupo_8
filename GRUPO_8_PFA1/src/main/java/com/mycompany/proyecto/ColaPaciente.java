/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 * Clase que representa una cola de pacientes.
 * Hereda de {ColaBase} y gestiona el registro y visualización de pacientes.
 */

public class ColaPaciente extends ColaBase{
    
     /**
     * Imprime la información de todos los pacientes en la cola.
     * Muestra una ventana por cada paciente con su nombre, cédula,
     * número de ficha y fecha de creación.
     * 
     */
    public void imprimirCola(){
        NodoCola aux = this.getFrente();
        while (aux != null){
            JOptionPane.showMessageDialog(null, "Nombre: "+aux.getNombre()
                    +"\nCédula: "+aux.getCedula()
                    +"\nNúmero de Ficha: "+aux.getNumeroFicha()
                    +"\nFecha de creación: "+aux.getFecha());
            aux = aux.getSiguiente();
        }
    }
    
    /**
     * Agrega un nuevo paciente a la cola.
     *
     * prefijo Prefijo para generar el número de ficha ("P" o "R").
     * nombre  Nombre del paciente.
     * cedula  Cédula del paciente.
     *
     * Genera automáticamente un número de ficha basado en el tamaño actual de la cola.
     * 
     */
    
    public void encolar(String prefijo, String nombre, String cedula){
        int tamanno = 1 + this.getTamaño();
        prefijo = prefijo + tamanno;
        JOptionPane.showMessageDialog(null,"Su número de ficha es la: "+prefijo);
        
        NodoCola aux = new NodoCola(nombre, cedula, prefijo);
        if (this.estaVacia()){
            this.setFrente(aux);
        }
        else{
           this.getUltimo().setSiguiente(aux);  
        }
        this.setUltimo(aux);
        this.setTamaño(tamanno);
    }
}
