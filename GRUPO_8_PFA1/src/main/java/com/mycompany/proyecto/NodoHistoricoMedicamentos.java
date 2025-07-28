/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;

/**
 * Clase que representa un nodo dentro de una lista enlazada para el historial
 * de medicamentos suministrados a un paciente.
 * Cada nodo contiene la cédula del paciente, la fecha de registro y los
 * medicamentos suministrados en ese momento.
 * 
 * Esta clase es utilizada para construir una estructura que almacena el
 * historial de medicamentos por paciente.
 * 
 */
public class NodoHistoricoMedicamentos {
    
    private int cedula;
    private Timestamp fecha;
    private String medicamentos;
    NodoHistoricoMedicamentos siguiente;

    public NodoHistoricoMedicamentos(int cedula, Timestamp fecha, String medicamentos) {
        this.cedula = cedula;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.siguiente = null;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
    
    
    
}
