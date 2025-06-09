package com.mycompany.proyecto;

import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;

/**
 *
 * @author Grupo 8
 */
public class Read {
    
    public static int readOption(Component posicion, String mensaje, 
            String titulo, int tipoOpcion, int tipoMensaje, 
            Icon icono, Object[] botones, Object inicio){
        int seleccion = -1;
        while (seleccion == -1){
            seleccion = JOptionPane.showOptionDialog(
                    null, mensaje, titulo, tipoOpcion, tipoMensaje, 
                    null, botones, inicio);
        
            if (seleccion == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción");
            }
        }
        return seleccion;
    }
    
    public static String readString(String mensaje) {
        String input = "";
        while (input == null || input.trim().isEmpty()) {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                        "El campo no puede estar vacío.");
            }
        }
        return input;
    }
    
    public static int readInt(String mensaje) {
        int num = 0;
        boolean valido = true;
        while (valido) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                num = Integer.parseInt(input);
                valido = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                        "Debe ingresar un valor numérico válido.");
            }
        }
        return num;
    }
    
    public static double readDouble(String mensaje) {
        double num = 0;
        boolean bucle = true;
        while (bucle) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                num = Double.parseDouble(input);
                bucle = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                        "Debe ingresar un valor numérico válido.");
            }
        }
        return num;
    }  
}
