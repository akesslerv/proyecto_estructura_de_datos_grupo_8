package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 * Clase para realizar lecturas de datos desde cuadros de diálogo. Contiene
 * métodos para leer cadenas, enteros y números decimales usando JOptionPane.
 */
public class Auxiliar {

    /**
     * Solicita al usuario ingresar una cadena de texto mediante un cuadro de
     * dialogo.
     *
     * <p>
     * Si el usuario presiona "Cancelar", el método retorna {null} para
     * indicar que la operación fue cancelada. Si el campo se deja vacío, se
     * ofrece al usuario la opción de intentar nuevamente o cancelar la
     * operación.</p>
     *
     */
    public static String readString(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje);

            if (input == null) {
                // Usuario presionó Cancelar
                return null;
            }

            if (input.trim().isEmpty()) {
            int resp = JOptionPane.showConfirmDialog(null,
                        "El campo no puede estar vacío. ¿Desea intentarlo de nuevo?",
                        "Campo vacío", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (resp == JOptionPane.NO_OPTION || resp == JOptionPane.CLOSED_OPTION) {
                    return null;
                }

            // Si elige "Sí", se vuelve a pedir input
            } else {
                return input.trim();
            }
        }
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
    
    public static int readIntNull(String mensaje) {
        int num = 0;
        
        while (true) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null) input = "-1";
            try {
                num = Integer.parseInt(input);
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar un valor numérico válido.");
            }
        }
    }

    static String pedirRazon(String ingrese_la_razón_por_la_que_abandona_la_c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
