/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author GRUPO 8
 */
public class ArbolBinario {
    
    //Atributo
    private NodoArbol raiz;
    
    //Constructor
    public ArbolBinario() {
    }
    
    public ArbolBinario(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    //Getter y Setter
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    //Metodos
    public static NodoArbol precargarArbol() {
    
    NodoArbol raiz = new NodoArbol("1", "Preguntas Frecuentes (FAQ)");
    NodoArbol nodoEmergencias = new NodoArbol("11", "Emergencias");
    NodoArbol nodoConsultaExterna = new NodoArbol("12", "Consulta Externa");

    raiz.setNodoIzq(nodoEmergencias);
    raiz.setNodoDer(nodoConsultaExterna);
    
    NodoArbol nodoEmergenciasMenores = new NodoArbol("111", "Emergencias Menores");
    NodoArbol nodoEmergenciasMayores = new NodoArbol("112", "Emergencias Mayores");
    nodoEmergencias.setNodoIzq(nodoEmergenciasMenores);
    nodoEmergencias.setNodoDer(nodoEmergenciasMayores);

    NodoArbol nodoServicios = new NodoArbol("121", "Servicios");
    nodoConsultaExterna.setNodoIzq(nodoServicios);
    
    NodoArbol nodoMayores18 = new NodoArbol("1111", "Mayores 18 años");
    NodoArbol nodoMenoresEdad = new NodoArbol("1112", "Menores de edad");
    nodoEmergenciasMenores.setNodoIzq(nodoMayores18);
    nodoEmergenciasMenores.setNodoDer(nodoMenoresEdad);

    NodoArbol nodoLaboratorio = new NodoArbol("1211", "Laboratorio");
    NodoArbol nodoFarmacia = new NodoArbol("1212", "Farmacia");
    nodoServicios.setNodoIzq(nodoLaboratorio);
    nodoServicios.setNodoDer(nodoFarmacia);
    
    Pregunta p1 = new Pregunta("1", "¿Cuál es el costo de consulta para adultos?", "El costo de atención en emergencias para un adulto es de 20,000 colones");
    Pregunta p2 = new Pregunta("2", "¿Cuál es el tiempo promedio de espera?", "Por tratarse de un servicio de emergencia no podemos garantizar un tiempo mínimo para atenciones menores. Sin embargo, en promedio demoramos 30 minutos.");
    p1.setSiguiente(p2);
    nodoMayores18.getListaPreguntas().setCabeza(p1);
    
    Pregunta p3 = new Pregunta("1", "¿Qué especialidad atiende a los niños?", "Contamos con pediatra las 24 horas del día.");
    Pregunta p4 = new Pregunta("2", "¿Se puede aplicar el seguro estudiantil?", "Si, recibimos todos los seguros médicos del mercado.");
    p3.setSiguiente(p4);
    nodoMenoresEdad.getListaPreguntas().setCabeza(p3);
    
    Pregunta p5 = new Pregunta("1", "Horario", "Atendemos 24 horas del día.");
    Pregunta p6 = new Pregunta("2", "Sucursales", "Tenemos sucursales en todo el país, ingrese a www.susalud.com/sucursales para mayor información");
    Pregunta p7 = new Pregunta("3", "Aplicar a una plaza", "Ingrese a ¡Error! Referencia de hipervínculo no válida.");
    p5.setSiguiente(p6);
    p6.setSiguiente(p7);
    nodoEmergenciasMayores.getListaPreguntas().setCabeza(p5);
    
    return raiz;
    }
}