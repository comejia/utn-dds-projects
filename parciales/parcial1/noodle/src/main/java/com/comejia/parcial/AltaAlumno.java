package com.comejia.parcial;

public class AltaAlumno implements Cambio {
    private Alumno alumno;

    public AltaAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void aplicarEn(Grupo grupo) {
        grupo.agregarAlumno(alumno);
    }
}
