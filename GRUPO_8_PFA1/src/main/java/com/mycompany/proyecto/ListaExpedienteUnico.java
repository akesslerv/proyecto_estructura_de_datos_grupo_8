/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import static com.mycompany.proyecto.Proyecto.ColaPreferencial;
import static com.mycompany.proyecto.Proyecto.ColaRegular;
import static com.mycompany.proyecto.Proyecto.PilaQuejas;
import static com.mycompany.proyecto.Proyecto.seleccionarFicha;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 8
 */
public class ListaExpedienteUnico {        
    
    class ListaHistoricoCitas{
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
        
        public String HistoricoCitas(int cedula)
        {
            NodoHistoricoCitas actual = cabeza;            
            StringBuilder cadena = new StringBuilder();
            
            while (actual != null)      
            {        
                if (actual.getCedula() == cedula)
                {                    
                    Timestamp fecha = actual.getFecha();
                    String doctor = actual.getDoctor();
                    String diagnostico = actual.getDiagnostico();
                    
                    cadena.append("Fecha: ").append(fecha).append(" Doctor: ").append(doctor).append(" Diagnóstico: ").append(diagnostico).append("\n");                                        
                }
                actual = actual.siguiente;
            }

            return cadena.toString();
        }
        
    };
    
    class ListaHistoricoMedicamentos{
        NodoHistoricoMedicamentos cabeza;
        NodoHistoricoMedicamentos ultimo;

        public ListaHistoricoMedicamentos() {
            this.cabeza = cabeza;
            this.ultimo = ultimo;
        }
        
        public void insertarOrdenado(int cedula, Timestamp fecha, String medicamentos)
        {
            NodoHistoricoMedicamentos nuevo = new NodoHistoricoMedicamentos(cedula, fecha, medicamentos);
            
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
                NodoHistoricoMedicamentos actual = cabeza;
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
        
        public String HistoricoMedicamentos(int cedula)
        {
            NodoHistoricoMedicamentos actual = cabeza;            
            StringBuilder cadena = new StringBuilder();
            
            while (actual != null)      
            {        
                if (actual.getCedula() == cedula)
                {                    
                    Timestamp fecha = actual.getFecha();
                    String medicamentos = actual.getMedicamentos();
                    
                    cadena.append("Fecha: ").append(fecha).append(" Medicamentos: ").append(medicamentos).append("\n");                                        
                }
                actual = actual.siguiente;
            }

            return cadena.toString();
        }
        
    };
    
    NodoExpedienteUnico cabeza;
    
    public void insertarOrdenado(int cedula, String nombre, int edad, String genero, Timestamp fecha)
    {
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
        } while (actual != cabeza ); //|| actual != null
        
        return false;
    }    
    
    public boolean ingresarExpedienteUnico(int cedula, String nombre, Timestamp fecha)
    {
        int edad = 0;
        String genero = null;
        System.out.println("Revisa en tiene expediente = false");
        if (tieneExpediente(cedula) == false)
        {   System.out.println("entro en el if");
            JOptionPane.showMessageDialog(null, "Paciente "+nombre+" asiste a consulta por primera vez");
            edad = Auxiliar.readIntNull("Ingrese la edad del paciente");
            if (edad == -1) return false;
            genero = Auxiliar.readString("Ingrese el genero del paciente");
            if (genero == null) return false;
        }
        else
        {System.out.println("entro en el else");
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
                    break; //actual = null; importante
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
        
        ListaHistoricoCitas historicoCitas = new ListaHistoricoCitas();
        historicoCitas.insertarOrdenado(cedula, fecha, doctor, diagnostico);
        
        ListaHistoricoMedicamentos historicoMedicamentos = new ListaHistoricoMedicamentos();
        historicoMedicamentos.insertarOrdenado(cedula, fecha, medicamentos);
        
        JOptionPane.showMessageDialog(null,"Expediente de usuario, ingresado correctamente");
        return true;
    }
    
    public void menuExpedienteUnico(int cedula, Boolean dato)
    {
        String[] botonesSubMenu = {
            "Anterior",
            "Siguiente",
            "Regresar"
        };

        boolean bucle = true;
        while (bucle) {
            int subMenu = JOptionPane.showOptionDialog(null,
                    "Seleccione una Opción",
                    "Hospital Su Salud",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botonesSubMenu,
                    botonesSubMenu[0]);

            switch (subMenu) {
                case 0 ->
                    seleccionarFicha();
                case 1 ->
                    Paciente.atenderPaciente();
                case 2 ->
                    bucle = false;
            }
        }
    }
    
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
            "Regresar"
        };

        boolean bucle = true;
        NodoExpedienteUnico actual = cabeza;
        ListaHistoricoCitas citas = new ListaHistoricoCitas();
        ListaHistoricoMedicamentos medicamentos = new ListaHistoricoMedicamentos();
        
        while (bucle)
        {
            String datos = "Expediente Único\n"
                    + " Cedula: " + actual.getCedula() + "\n"
                    + " Nombre: " + actual.getNombre() + "\n"
                    + " Edad: " + actual.getEdad() + "\n"
                    + " Género: " + actual.getGenero() + "\n"
                    +"\nHistorial Citas Médicas\n"
                    + citas.HistoricoCitas(actual.getCedula()) + "\n"
                    +"\nHistorial Medicamentos\n"
                    + medicamentos.HistoricoMedicamentos(actual.getCedula()) + "\n";
            
            int subMenu = JOptionPane.showOptionDialog(null,
                    datos,
                    "Hospital Su Salud",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botonesSubMenu,
                    botonesSubMenu[0]);

            switch (subMenu) {
                case 0 ->
                    menuExpedienteUnico(actual.getCedula(), false);
                case 1 ->
                    menuExpedienteUnico(actual.getCedula(), true);
                case 2 ->
                    bucle = false;
            }
        }       
    }
}
