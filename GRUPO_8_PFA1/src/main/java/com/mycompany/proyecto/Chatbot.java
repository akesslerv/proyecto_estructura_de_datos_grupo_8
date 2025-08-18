/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 8
 */
public class Chatbot {
    
    public static ArbolBinario arbol = new ArbolBinario();
    
    /**
     * Muestra el submenú del chatbot para seleccionar entre ver el chatbot como
     * vista de usuarios e ingresar al mantenimiento del chatbot para el personal
     * administrativo
     */
    public static void menuChatbot() {
        
        String[] subMenuChatbot = {
            "Ver Chatbot (Usuarios)",
            "Mantenimiento Chatbot (Personal Administrativo)",
            "Regresar"
        };
        
        boolean bucle = true;
        while (bucle){
            int selecOpcion = JOptionPane.showOptionDialog(null,
                "Seleccione una Opcion",
                "Hospital su salud",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                subMenuChatbot,
                subMenuChatbot[0]);

            switch (selecOpcion) {
                case 0:
                    verChatbot();
                    break;
                case 1:
                    mantenimientoChatbot();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el Chatbot. ¡Hasta luego!");
                    bucle = false;
            }
        }
    }

    private static void verChatbot() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido al Chatbot de Preguntas Frecuentes!");
        // codigo
    }

    private static void mantenimientoChatbot() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido a Mantenimiento del Chatbot de Preguntas Frecuentes!");
        // codigo
    }
}