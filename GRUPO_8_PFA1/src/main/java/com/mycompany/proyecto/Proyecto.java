package com.mycompany.proyecto;

import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Grupo 8
 */
public class Proyecto {

    public static void main(String[] args) {
        Icon icono = new ImageIcon(Read.class.getResource(
                "/imagenes/Logo.jpg"));
        
        String [] botonesMenuPrincipal = { 
        "Gestionar Llegada de Pacientes",
        "Ayuda",
        "Salir"
        };
        
        while (true){
            int menuPrincipal = Read.readOption(null,
                    "Seleccione una Opción", 
                    "Hospital Su Salud", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.PLAIN_MESSAGE, 
                    icono, 
                    botonesMenuPrincipal, 
                    botonesMenuPrincipal[0]);
    
            switch (menuPrincipal){
                case 0 -> gestionarPacientes();
        
                case 1 -> {
                }
            
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el Sistema!");
                    System.exit(0);
                }
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
            int subMenu = Read.readOption(null,
                    "Seleccione una Opción", 
                    "Hospital Su Salud", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    botonesSubMenu, 
                    botonesSubMenu[0]);
            
            switch (subMenu){
                case 0 -> {
                }
        
                case 1 -> {
                }
            
                case 2 -> {
                }
                
                case 3 -> {
                }
                
                case 4 -> {
                }
                    
                case 5 -> bucle = false;  
            }
        }
    }  
}