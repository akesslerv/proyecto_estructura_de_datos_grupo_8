/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 * @author GRUPO 8
 * Clase que representa una cola de pacientes. Hereda de {ColaBase} y gestiona
 * el registro y visualización de pacientes.
 */
public class ColaPaciente extends ColaBase {
       private int contadorFichas = 0;
    
       
    /**
     * Imprime la información de todos los pacientes en la cola. Muestra una
     * ventana por cada paciente con su nombre, cédula, número de ficha y fecha
     * de creación.
     *
     */
    public void imprimirCola() {
        NodoCola aux = this.getFrente();
        while (aux != null) {
            JOptionPane.showMessageDialog(null, "Nombre: " + aux.getNombre()
                    + "\nCédula: " + aux.getCedula()
                    + "\nNúmero de Ficha: " + aux.getNumeroFicha()
                    + "\nFecha de creación: " + aux.getFecha());
            aux = aux.getSiguiente();
        }
    }

    /**
     * Agrega un nuevo paciente a la cola.prefijo Prefijo para generar el número de ficha ("P" o "R").nombre
 Nombre del paciente.cedula Cédula del paciente.
     *
     * Genera automáticamente un número de ficha basado en el tamaño actual de
 la cola.
     *
     * @param prefijo
     * @param nombre
     * @param cedula
     */   
    
       @Override
    public void encolar(String prefijo, String nombre, String cedula) {
        contadorFichas++;
        String ficha = prefijo + contadorFichas;
        NodoCola nodo = new NodoCola(nombre, cedula, ficha);
        if (this.estaVacia()) {
            this.setFrente(nodo);
        } else {
            this.getUltimo().setSiguiente(nodo);
        }
        this.setUltimo(nodo);
        this.setTamaño(this.getTamaño() + 1);
    }
    
    /**
     * Elimina el primer nodo de la cola sin retonar el nodo eliminado.
     */
    public void desencolarSinRetorno() {
        if (getFrente() == null) {
            return;
        }
        NodoCola nodoDesencolado = getFrente();
        setFrente(getFrente().getSiguiente());
        int tamanno = getTamaño();
        tamanno --;
        if (getFrente() == null) {
            setUltimo(null);
        }
        nodoDesencolado.setSiguiente(null);
    }

}


