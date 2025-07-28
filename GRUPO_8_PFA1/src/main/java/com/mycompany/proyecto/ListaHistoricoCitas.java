/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;

/**
 *
 * @author barre
 */
public class ListaHistoricoCitas {
    NodoHistoricoCitas cabeza;
    NodoHistoricoCitas ultimo;

        public ListaHistoricoCitas() {
            this.cabeza = cabeza;
            this.ultimo = ultimo;
        }
        
        public void insertarOrdenado(int cedula, Timestamp fecha, String doctor, String diagnostico)
        {
            NodoHistoricoCitas nuevo = new NodoHistoricoCitas(cedula, fecha, doctor, diagnostico);
            
            if (cabeza == null)
            {                
                cabeza = nuevo;
                ultimo = nuevo;
                ultimo.siguiente = cabeza;
            }
            else if (cedula < cabeza.getCedula())
            {
                //Insertar al inicio
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
                ultimo.siguiente = cabeza;
            }
            else
            {
                //Buscar posición de inserción
                NodoHistoricoCitas actual = cabeza;
                while (actual.siguiente != cabeza && actual.siguiente.getCedula() < cedula)
                {
                    actual = actual.siguiente;                    
                }
                
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
                if (actual == ultimo)
                {
                    ultimo = nuevo;
                }
            }
            
        }
        
        public boolean estaVacia() 
        {
            return cabeza == null;
        }
        
    public String mostrarHistorialCitas(int cedula) {
        NodoHistoricoCitas actual = cabeza;
        String texto = "";
        boolean encontrado = false;
        do {
            if (actual.getCedula() == cedula) {
                texto += "Fecha: " + actual.getFecha()
                    + "\nDoctor: " + actual.getDoctor()
                    + "\nDiagnóstico: " + actual.getDiagnostico()
                    + "\n";
                encontrado = true;
            }
            actual = actual.siguiente;
        }while (actual != cabeza);
        if (!encontrado) {
            texto += "No hay citas registradas para esta cédula.";
        }
        return texto;
    }
        
};

