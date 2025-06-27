package com.mycompany.proyecto;

import javax.swing.JOptionPane;


/**
 *
 * @author Dilan
 */
public class Proyecto {
    
    static ColaPaciente ColaRegular = new ColaPaciente();
    static ColaPaciente ColaPreferencial = new ColaPaciente();
    
    public static void main(String[] args) {
        String [] botonesMenuPrincipal = { 
        "Gestionar Llegada de Pacientes",
        "Ayuda",
        "Salir"
        };
        
        while (true){
            int menuPrincipal = JOptionPane.showOptionDialog(null,
                    "Seleccione una Opción", 
                    "Hospital Su Salud", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    botonesMenuPrincipal, 
                    botonesMenuPrincipal[0]);
    
            switch (menuPrincipal){
                case 0:
                    gestionarPacientes();
                    break;
        
                case 1:
                    break;
            
                case 2:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el Sistema!");
                    System.exit(0);
                    break;
            }
        }
    }
    
    public static void gestionarPacientes(){
        String [] botonesSubMenu = {
            "Seleccionar Ficha",
            "Atender Paciente",
            "Abandonar Cola",
            "Mostrar Fichas Pendientes",
            "Mostrar Quejas Recibidas",
            "Regresar"
        };
        
        boolean bucle = true;
        while (bucle){
            int subMenu = JOptionPane.showOptionDialog(null,
                    "Seleccione una Opción", 
                    "Hospital Su Salud", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    botonesSubMenu, 
                    botonesSubMenu[0]);
            
            switch (subMenu){
                case 0:
                    selecionarFicha();
                    break;
        
                case 1:
                    break;
            
                case 2:
                    break;
                
                case 3:
                    break;
                
                case 4:
                    break;
                    
                case 5:
                    bucle = false;
                    break;  
            }
        }
    }
    
    public static void selecionarFicha(){
        String [] botonesSelecFicha = {
                    "Paciente Regular",
                    "Paciente Preferencial",
                    "Regresar"
                    };
        
        int subSelecFicha = JOptionPane.showOptionDialog(null,
                    "Seleccione el tipo de Paciente", 
                    "Hospital Su Salud", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    botonesSelecFicha, 
                    botonesSelecFicha[0]);
        
        boolean bucle = true;
        String prefijo;
        String nombre = Read.readString("Ingrese el nombre del Paciente");
        String cedula = Read.readString("Ingrese la cédula del Paciente");
        while (bucle){
            switch(subSelecFicha){
                case 0:
                    prefijo = "R";
                    ColaRegular.encolar(prefijo, nombre, cedula);
                    bucle = false;
                    break;
                 
                case 1:
                    prefijo = "P";
                    ColaPreferencial.encolar(prefijo, nombre, cedula);
                    bucle = false;
                    break;
                    
                case 2:
                    bucle = false;
                    break;
            }
        }
    }
}
