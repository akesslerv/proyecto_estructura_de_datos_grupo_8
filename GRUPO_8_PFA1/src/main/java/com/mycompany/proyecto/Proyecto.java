package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 8
 */
/**
 * Clase principal del sistema "Hospital Su Salud". Gestiona el menú principal y
 * las operaciones relacionadas con la atención de pacientes, selección de
 * fichas, colas, quejas y visualización de datos.
 */
public class Proyecto {

    // Colas de pacientes
    public static ColaPaciente ColaRegular = new ColaPaciente();
    public static ColaPaciente ColaPreferencial = new ColaPaciente();
    public static ColaPaciente ColaAtendidos = new ColaPaciente();

    // Pila de quejas
    public static PilaQuejas pilaQuejas = new PilaQuejas();
    public static PilaQuejas PilaQuejas = new PilaQuejas();

    // Estructuras del avance 2
    public static BitacoraCitas bitacoraCitas = new BitacoraCitas();
    public static ListaExpedienteUnico expedienteUnico = new ListaExpedienteUnico();
    

    /**
     * Método principal del programa.Muestra el menú principal con opciones para
     * gestionar pacientes, ver ayuda o salir.
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] botonesMenuPrincipal = {
            "Gestionar Llegada de Pacientes",
            "Bitácora de Citas del Día",
            "Expediente único de Pacientes",
            "Buscar Citas por Cédula",
            "Ayuda",
            "ChatBot",
            "Salir"
        };

        while (true) {
            int menuPrincipal = JOptionPane.showOptionDialog(null,
                    "Seleccione una Opción",
                    "Hospital Su Salud",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botonesMenuPrincipal,
                    botonesMenuPrincipal[0]);

            switch (menuPrincipal) {
                case 0:
                    gestionarPacientes();
                    break;
                case 1:
                    bitacoraCitas.mostrarBitacoraSimple(); // Bitácora general
                    break;
                case 2:
                    expedienteUnico.mostrarExpedienteUnico();
                    break;
                case 3:
                    Paciente.mostrarBitacoraPorCedula();
                    break;
                case 4:
                    mostrarAyuda();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "¡Chatbot!");
                    System.exit(0);
                case 6:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el Sistema!");
                    System.exit(0);
            }
        }
    }

    /**
     * Muestra el submenú para gestionar pacientes. Incluye opciones para
     * seleccionar ficha, atender, abandonar cola, mostrar fichas pendientes,
     * ver quejas y regresar al menú principal.
     */
    public static void gestionarPacientes() {
        String[] botonesSubMenu = {
            "Seleccionar Ficha",
            "Atender Paciente",
            "Abandonar Cola de Pacientes",
            "Mostrar Fichas Pendientes",
            "Mostrar Quejas Recibidas",
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
                    GestionColas.abandonarCola(ColaPreferencial, ColaRegular, PilaQuejas);
                case 3 ->
                    GestionColas.mostrarFichasPendientes(ColaPreferencial, ColaRegular);
                case 4 ->
                    GestionColas.mostrarQuejasRecibidas(PilaQuejas);
                case 5 ->
                    bucle = false;
            }
        }
    }

    /**
     * Permite registrar un paciente como regular o preferencial. Solicita
     * nombre y cédula, luego asigna el tipo según opción elegida.
     */
    public static void seleccionarFicha() {
        String[] botonesSelecFicha = {
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

        if (subSelecFicha == 2 || subSelecFicha == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String nombre = Auxiliar.readString("Ingrese el nombre del Paciente");
        String cedula = Auxiliar.readString("Ingrese la cédula del Paciente");

        String prefijo = (subSelecFicha == 1) ? "P" : "R";
        if (prefijo.equals("P")) {
            ColaPreferencial.encolar(prefijo, nombre, cedula);
        } else {
            ColaRegular.encolar(prefijo, nombre, cedula);
        }
    }
    
    public static void mostrarAyuda() {
        String ayuda = """
                🏥 Hospital Su Salud - Sistema de Gestión de Pacientes
            
                Este sistema permite gestionar la llegada y atención de pacientes.
                Opciones disponibles en el submenú de atención:
                        
                0 - Seleccionar ficha:
                    Registra un paciente en la cola de espera del sistema
                        
                1 - Atender paciente:
                    Atiende al siguiente paciente, según prioridad (preferencial o regular).
                        
                2 - Abandonar cola:
                    Permite que un paciente salga de la fila y registre una queja opcional.
                        
                3 - Mostrar fichas pendientes:
                    Muestra los pacientes aún en espera en ambas colas.
                        
                4 - Ver quejas recibidas:
                    Lista todas las quejas registradas por los pacientes.
                        
                5 - Salir:
                    Cierra el submenú de atención y regresa al menú principal.

                Nota: La atención prioriza la cola preferencial sobre la regular.
                        
                Versión: 3.1.0
                
                Autores:
                • Jousteen José Cordero Valerio
                <jcordero60060@ufide.ac.cr>
                • Alessandra Barbara Kessler Valdivia
                <akessler70010@ufide.ac.cr>
                • Dilan Adolfo Palacio Artiles
                <dpalacio18910@ufide.ac.cr>
                • Emely Tatiana Sellis Alegría
                <esellis91302@ufide.ac.cr>
                
                """;

        JOptionPane.showMessageDialog(null, ayuda, "Ayuda del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }  
}