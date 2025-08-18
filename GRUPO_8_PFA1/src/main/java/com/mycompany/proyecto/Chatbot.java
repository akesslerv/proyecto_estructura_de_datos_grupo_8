/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author JousteenCordero(jcordero60060@ufide.ac.cr)
 */
public class Chatbot {
    
    /**
     * Muestra el submenú del chatbot para seleccionar entre ver el chatbot como
     * vista de usuarios e ingresar al mantenimiento del chatbot para el personal
     * administrativo
     */
    public static void menuChatbot() {
        
        String[] botonesSubMenu = {
            "Ver Chatbot (Usuarios)",
            "Mantenimiento del Chatbot (Personal Administrativo)",
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
                    bucle = false;
                case 1 ->
                    bucle = false;
                case 2 ->
                    bucle = false;
            }
        }
    }
}