/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;


/**
 * @author GRUPO 8
 * La clase NodoHistoricoCitas representa un nodo de una lista enlazada simple
 * que almacena el historial de citas médicas de un paciente.
 * Contiene información básica como cédula, fecha de la cita, nombre del doctor
 * y el diagnóstico.
 * 
 */

public class NodoHistoricoCitas {
    
    private int cedula;
    private Timestamp fecha;
    private String doctor, diagnostico;
    NodoHistoricoCitas siguiente;

    public NodoHistoricoCitas(int cedula, Timestamp fecha, String doctor, String diagnostico) {
        this.cedula = cedula;
        this.fecha = fecha;
        this.doctor = doctor;
        this.diagnostico = diagnostico;
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
    
}
