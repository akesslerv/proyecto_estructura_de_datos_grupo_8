package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Dilan
 */
public class Read {
    
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
