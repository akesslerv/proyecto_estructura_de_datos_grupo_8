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

    //gestion de colas
    static ColaPaciente ColaRegular = new ColaPaciente();
    static ColaPaciente ColaPreferencial = new ColaPaciente();
    static ColaPaciente ColaAtendidos = new ColaAtendidos();
    static PilaQuejas PilaQuejas = new PilaQuejas();
    int ContadorPreferenciales = 0;

    /**
     * Método principal del programa.Muestra el menú principal con opciones para
     * gestionar pacientes, ver ayuda o salir.
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] botonesMenuPrincipal = {
            "Gestionar Llegada de Pacientes",
            "Ayuda",
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
                    Ayuda.mostrarAyuda();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el Sistema!");
                    System.exit(0);
                    break;
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
            "Abandonar Cola",
            "Mostrar Fichas Pendientes",
            "Mostrar Quejas Recibidas",
            "Mostrar Bitácora de Atendidos",
            "Buscar Bitácora por Cédula", // <- Nuevo
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
                case 0:
                    selecionarFicha();
                    break;

                case 1:
                    Paciente.atenderPaciente();
                    break;

                case 2:
                    GestionColas.abandonarCola(ColaPreferencial, ColaRegular, PilaQuejas);
                    break;

                case 3:
                    GestionColas.mostrarFichasPendientes(ColaPreferencial, ColaRegular);
                    break;

                case 4:
                    GestionColas.mostrarQuejasRecibidas(PilaQuejas);
                    break;

                case 5:
                    Paciente.mostrarBitacora();
                    break;

                case 6:
                    Paciente.mostrarBitacoraPorCedula();
                    break;
                case 7:
                    bucle = false;
                    break;
            }
        }
    }

    /**
     * Permite registrar un paciente como regular o preferencial. Solicita
     * nombre y cédula, luego asigna el tipo según opción elegida.
     */
    public static void selecionarFicha() {
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

        boolean bucle = true;
        String prefijo;
        String nombre = Read.readString("Ingrese el nombre del Paciente");
        String cedula = Read.readString("Ingrese la cédula del Paciente");
        while (bucle) {
            switch (subSelecFicha) {
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

