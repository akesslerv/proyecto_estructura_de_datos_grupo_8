package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 * @author GRUPO 8
 * Clase para realizar lecturas de datos desde cuadros de diálogo. Contiene
 * métodos para leer cadenas, enteros y números decimales usando JOptionPane.
 */
public class Auxiliar {

    /**
     * Solicita al usuario ingresar una cadena de texto mediante un cuadro de
     * dialogo.
     *
     * <p>
     * Si el usuario presiona "Cancelar", el método retorna {null} para indicar
     * que la operación fue cancelada. Si el campo se deja vacío, se ofrece al
     * usuario la opción de intentar nuevamente o cancelar la operación.</p>
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
    
    public static String readCedula(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje);

            if (input == null) {
                // Usuario presionó Cancelar
                return null;
            }
            
                // Valida que la cedula solo contenga números
            if (!input.trim().matches("\\d+")){
                JOptionPane.showMessageDialog(null,
                "La cédula unicamente puede contener números");
                return input.trim();

            } else if (input.trim().isEmpty()) {
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

    /**
     * Solicita al usuario ingresar un número entero mediante un cuadro de
     * diálogo.
     *
     * <p>
     * El método repetirá la solicitud hasta que se ingrese un valor numérico
     * válido.
     * </p>
     *
     * @param mensaje El mensaje que se muestra en el cuadro de diálogo.
     * @return El entero ingresado por el usuario.
     */
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

    /**
     * Solicita al usuario ingresar un número decimal (double) mediante un
     * cuadro de diálogo.
     *
     * <p>
     * El método repetirá la solicitud hasta que se ingrese un valor numérico
     * válido.
     * </p>
     *
     * @param mensaje El mensaje que se muestra en el cuadro de diálogo.
     * @return El número decimal ingresado por el usuario.
     */
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

    /**
     * Solicita al usuario ingresar un número entero mediante un cuadro de
     * diálogo.
     *
     * <p>
     * Si el usuario presiona "Cancelar", retorna -1. Repite la solicitud hasta
     * recibir un valor numérico válido o cancelar.
     * </p>
     *
     * @param mensaje El mensaje que se muestra en el cuadro de diálogo.
     * @return El entero ingresado o -1 si se cancela.
     */
    public static int readIntNull(String mensaje) {
        int num = 0;

        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) {
                input = "-1";
            }
            try {
                num = Integer.parseInt(input);
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar un valor numérico válido.");
            }
        }
    }

    /**
     * Método placeholder para solicitar la razón por la que un usuario abandona
     * la operación.
     *
     * @param ingrese_la_razón_por_la_que_abandona_la_c Mensaje para el diálogo.
     * @throws UnsupportedOperationException porque no está implementado aún.
     */
    static String pedirRazon(String ingrese_la_razón_por_la_que_abandona_la_c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
