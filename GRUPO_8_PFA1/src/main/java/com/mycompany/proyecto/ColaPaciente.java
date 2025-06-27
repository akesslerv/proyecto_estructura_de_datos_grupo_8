/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author barre
 */
public class ColaPaciente extends ColaBase{
    
    public void imprimirCola(){
        NodoCola aux = this.getFrente();
        while (aux != null){
            JOptionPane.showMessageDialog(null, "Nombre: "+aux.getNombre()
                    +"\nCédula: "+aux.getCedula()
                    +"\nNúmero de Ficha: "+aux.getNumeroFicha());
            aux = aux.getSiguiente();
        }
    }
    
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
