/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Timestamp;
import javax.swing.JOptionPane;


/**
 * @author GRUPO 8
 * Clase que representa una lista doblemente enlazada circular de expedientes únicos de pacientes.
 * 
 * Cada expediente incluye los datos personales de un paciente y se asocia a su historial
 * de citas médicas y medicamentos. Los nodos están ordenados ascendentemente por cédula.
 * Permite la navegación entre pacientes y visualización de sus historiales.
 * 
 * además, mantiene una lista global estática para almacenar el historial de citas
 * y medicamentos, compartida por todos los expedientes.
 * 
 */

public class ListaExpedienteUnico extends ListaDobleCircular{        
    NodoExpedienteUnico cabeza;
    public static ListaHistoricoCitas historicoCitas = new ListaHistoricoCitas();
    public static ListaHistoricoMedicamentos historicoMedicamentos = new ListaHistoricoMedicamentos();
        
    /**
     * Inserta un nuevo expediente ordenado por cédula de forma ascendente.
     *
     */
    public void insertarOrdenado(int cedula, String nombre, int edad, String genero, Timestamp fecha){
            NodoExpedienteUnico nuevo = new NodoExpedienteUnico(cedula, nombre, edad, genero, fecha);
            
            if (cabeza == null)
            {                
                cabeza = nuevo;
                cabeza.siguiente = cabeza;
                cabeza.anterior = cabeza;
            }
            else if (cedula <= cabeza.getCedula())
            {
                //Insertar al inicio si el valor es menor
                NodoExpedienteUnico ultimo = cabeza.anterior;
                nuevo.siguiente = cabeza;
                nuevo.anterior = ultimo;
                cabeza.anterior = nuevo;
                ultimo.siguiente = nuevo;
                cabeza = nuevo; //Actualiza cabeza                
            }
            else
            {
                //Buscar posición de inserción
                NodoExpedienteUnico actual = cabeza;
                while (actual.siguiente != cabeza && actual.siguiente.getCedula() < cedula)
                {
                    actual = actual.siguiente;                    
                }
                
                //Insertar después de 'actual'
                nuevo.siguiente = actual.siguiente;
                nuevo.anterior = actual;
                actual.siguiente.anterior = nuevo;
                actual.siguiente = nuevo;
            }
            
        }
    
     /**
     * Verifica si ya existe un expediente con la cédula dada.
     *
     */
    public boolean tieneExpediente(int cedula)
    {
        if (cabeza == null)
        {
            return false;
        }
        
        NodoExpedienteUnico actual = cabeza;
        
        do
        {
            if (actual.getCedula() == cedula)
            {
                return true;
            }
            actual = actual.siguiente;            
        } while (actual != cabeza );
        
        return false;
    }    
        
    /**
     * Ingresa un nuevo expediente al sistema. Si el paciente ya existe, muestra su información.
     * En ambos casos, agrega una nueva cita médica y medicamentos a su historial.
     *
     */
    public boolean ingresarExpedienteUnico(int cedula, String nombre, Timestamp fecha)
    {
        int edad = 0;
        String genero = null;
        if (tieneExpediente(cedula) == false)
        {   
            JOptionPane.showMessageDialog(null, "Paciente "+nombre+" asiste a consulta por primera vez");
            edad = Auxiliar.readIntNull("Ingrese la edad del paciente");
            if (edad == -1) return false;
            genero = Auxiliar.readString("Ingrese el genero del paciente");
            if (genero == null) return false;
        }
        else
        {
            NodoExpedienteUnico actual = cabeza;
            while (actual != null) 
            {
                if (actual.getCedula() == cedula)
                {
                    JOptionPane.showMessageDialog(null,
                    "Cedula: " + cedula
                    + " Nombre: " + nombre
                    + " Edad: " + actual.getEdad()
                    + " Género: " + actual.getGenero());
                    edad = actual.getEdad();
                    genero = actual.getGenero();
                    break;
                }
                
                actual = actual.getSiguiente();
            }
        }
                
        //Se piden los datos necesitados para Historico de Citas y Medicamentos
        String doctor = Auxiliar.readString("Ingrese el nombre del doctor que atiende");
        if (doctor == null) return false;
        String diagnostico = Auxiliar.readString("Ingrese el diagnostico del paciente");
        if (diagnostico == null) return false;
        String medicamentos = Auxiliar.readString("Ingrese los medicamentos prescriptos");
        if (medicamentos == null) return false;
        
        insertarOrdenado(cedula, nombre, edad, genero, fecha);
        
        
        historicoCitas.insertarOrdenado(cedula, fecha, doctor, diagnostico);
        historicoMedicamentos.insertarOrdenado(cedula, fecha, medicamentos);
        
        JOptionPane.showMessageDialog(null,"Expediente de usuario, ingresado correctamente");
        return true;
    }
    
    /**
     * Muestra el expediente completo de cada paciente almacenado en la lista.
     * Incluye los historiales de citas y medicamentos, si existen.
     */
    public void mostrarExpedienteUnico()
    {
        if (cabeza == null)
        {
            JOptionPane.showMessageDialog(null, "No hay expedientes de pacientes");
            return;
        }
        
        String[] botonesSubMenu = {
            "Anterior",
            "Siguiente",
            "Historico de Medicamentos",
            "Historico de Citas",
            "Regresar"
        };

        boolean bucle = true;
        NodoExpedienteUnico actual = cabeza;
        NodoExpedienteUnico temp = actual;
        while (bucle)
        {   
            String datos = "Expediente Único\n"
                    + " Cedula: " + actual.getCedula() + "\n"
                    + " Nombre: " + actual.getNombre() + "\n"
                    + " Edad: " + actual.getEdad() + "\n"
                    + " Género: " + actual.getGenero() + "\n"
                    ;
            
            int subMenu = JOptionPane.showOptionDialog(null,
                    datos,
                    "Hospital Su Salud",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botonesSubMenu,
                    botonesSubMenu[0]);

            switch (subMenu) {
                case 0:
                    if (actual == actual.getAnterior()){
                        JOptionPane.showMessageDialog(null, "No hay más expedientes de pacientes");
                    }
                    actual = actual.getAnterior();
                    break;
                case 1:
                    if (actual == actual.getSiguiente()){
                        JOptionPane.showMessageDialog(null, "No hay más expedientes de pacientes");
                    }
                    actual = actual.getSiguiente();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "\nnHistorial Medicamentos\n"
                        + historicoMedicamentos.mostrarHistorialMedicamentos(actual.getCedula())
                        );
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "\nHistorial Citas Médicas\n"
                        + historicoCitas.mostrarHistorialCitas(actual.getCedula())
                        );
                    break;
                case 4:
                    bucle = false;
            }
        }       
    }
}
