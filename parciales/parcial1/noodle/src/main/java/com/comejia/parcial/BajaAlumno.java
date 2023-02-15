package com.comejia.parcial;

public class BajaAlumno implements Cambio {
    private Alumno alumno;

    public BajaAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void aplicarEn(Grupo grupo) {
        grupo.eliminarAlumno(alumno);
    }
}
