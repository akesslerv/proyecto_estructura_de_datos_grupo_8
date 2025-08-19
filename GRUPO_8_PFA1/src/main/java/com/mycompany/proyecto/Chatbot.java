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
    
    /**
     * Muestra el submenú del chatbot para seleccionar entre ver el chatbot como
     * vista de usuarios e ingresar al mantenimiento del chatbot para el personal
     * administrativo
     */
    public static class NodoCamino {
        public NodoArbol nodo;         
        public NodoCamino siguiente;   

        public NodoCamino(NodoArbol nodo, NodoCamino siguiente) {
            this.nodo = nodo;
            this.siguiente = siguiente;
        }
    }

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
        
        if (Proyecto.arbol.getRaiz() == null) {
            JOptionPane.showMessageDialog(null, "El Chatbot no está disponible en este momento.");
            return;
        }

        JOptionPane.showMessageDialog(null, "¡Bienvenido al Chatbot de Preguntas Frecuentes!");

        NodoArbol actual = Proyecto.arbol.getRaiz();
        NodoCamino camino = null; 

        boolean bucle = true;
        while (bucle && actual != null) {
            
            if (actual.getNodoIzq() == null && actual.getNodoDer() == null) {
                
                Pregunta pregunta = actual.getListaPreguntas().getCabeza();
                java.util.List<String> opciones = new java.util.ArrayList<>();
                java.util.List<Pregunta> preguntasList = new java.util.ArrayList<>();
                while (pregunta != null) {
                    opciones.add(pregunta.getNombre());
                    preguntasList.add(pregunta);
                    pregunta = pregunta.getSiguiente();
                }
                opciones.add("Regresar");

                int seleccion = JOptionPane.showOptionDialog(null,
                        "Seleccione una pregunta:",
                        actual.getNombre(),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones.toArray(),
                        opciones.get(0));

                if (seleccion == opciones.size() - 1) {
                    
                    if (camino != null) {
                        actual = camino.nodo;
                        camino = camino.siguiente; 
                    } else {
                        bucle = false;
                    }
                } else if (seleccion >= 0 && seleccion < preguntasList.size()) {
                    
                    Pregunta preg = preguntasList.get(seleccion);
                    JOptionPane.showMessageDialog(null, preg.getRespuesta(), preg.getNombre(), JOptionPane.INFORMATION_MESSAGE);
                } else {
                    bucle = false;
                }
            } else {
                
                java.util.List<NodoArbol> hijos = new java.util.ArrayList<>();
                java.util.List<String> opciones = new java.util.ArrayList<>();
                if (actual.getNodoIzq() != null) {
                    hijos.add(actual.getNodoIzq());
                    opciones.add(actual.getNodoIzq().getNombre());
                }
                if (actual.getNodoDer() != null) {
                    hijos.add(actual.getNodoDer());
                    opciones.add(actual.getNodoDer().getNombre());
                }
                opciones.add("Regresar");

                int seleccion = JOptionPane.showOptionDialog(null,
                        "Seleccione una categoría:",
                        actual.getNombre(),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones.toArray(),
                        opciones.get(0));

                if (seleccion == opciones.size() - 1) {
                    
                    if (camino != null) {
                        actual = camino.nodo;
                        camino = camino.siguiente;
                    } else {
                        bucle = false;
                    }
                } else if (seleccion >= 0 && seleccion < hijos.size()) {
                    
                    camino = new NodoCamino(actual, camino);
                    actual = hijos.get(seleccion);
                } else {
                    bucle = false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "¡Gracias por usar el Chatbot! Hasta pronto.");
    }


    private static void mantenimientoChatbot() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido a Mantenimiento del Chatbot de Preguntas Frecuentes!");
        // codigo
    } 
}