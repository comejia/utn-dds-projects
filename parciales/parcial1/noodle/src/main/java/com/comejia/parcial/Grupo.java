package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class Grupo {
    private int tamIdeal;
    private boolean grupoAbierto;
    private List<Alumno> alumnos;
    private Correo correo;
    private SCM scm;
    private List<Cambio> cambiosPendientes;

    public Grupo(int tamIdeal) {

        this.tamIdeal = tamIdeal;
    }

    public void inscribir(Alumno alumno) {
        if (grupoAbierto) {
            agregarAlumno(alumno);
        } else {
            posponerInscripcion(alumno);
        }
    }

    public void notificarAlta(Alumno alumno) {
        this.correo.enviar(getMailsAlumnos(), "Inscripcion alumno", "Se inscribio: " + alumno.getNombre());
    }

    public String getMailsAlumnos() {
        return this.alumnos.stream()
                .map(Alumno::getMail)
                .collect(Collectors.joining(","));
    }

    public void posponerInscripcion(Alumno alumno) {
        this.cambiosPendientes.add(new AltaAlumno(alumno));
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
        notificarAlta(alumno);
    }

    public void darBaja(Alumno alumno) {
        if (grupoAbierto) {
            eliminarAlumno(alumno);
        } else {
            posponerBaja(alumno);
        }
    }

    public void notificarBaja(Alumno alumno) {
        this.correo.enviar(getMailsAlumnos(), "Baja de alumno", "Se dio de baja: " + alumno.getNombre());
    }

    public void posponerBaja(Alumno alumno) {
        this.cambiosPendientes.add(new BajaAlumno(alumno));
    }

    public void eliminarAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
        notificarBaja(alumno);
    }

    public void cerrar() {
        if (this.alumnos.size() == tamIdeal) {
            efectivizarCierre();
        } else {
            posponerCierre();
        }
    }

    public void posponerCierre() {
        this.cambiosPendientes.add(new Cierre());
    }

    public void efectivizarCierre() {
        this.grupoAbierto = false;
        crearRepositorio();
    }

    public void crearRepositorio() {
        this.scm.crearRepositorio("DDS", getUsuarios());
    }

    private List<String> getUsuarios() {
        return this.alumnos.stream()
                .map(Alumno::getUsuario)
                .collect(Collectors.toList());
    }

    public void aprobarCambio(Cambio cambio) {
        this.cambiosPendientes.remove(cambio);
        cambio.aplicarEn(this);
    }

    public void rechazarCambio(Cambio cambio) {
        //cambio.aplicarEn(this);
        this.cambiosPendientes.remove(cambio);
    }
}
