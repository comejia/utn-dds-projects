package com.comejia.parcial;

public class MelodiaPersonalizada implements Melodia {

    byte[] audio;
    String midi;
    EstadoValidacion estadoValidacion;

    public MelodiaPersonalizada(byte[] audio) {
        this.audio = audio;
        //convertir(audio); no va porque se bloquea por el tiempo que toma la conversion
    }

    // Se ejecuta desde un cron que corre todo el tiempo (ejemplo una vez x minuto)
    // mediante un main { ... RepoOrdenes.getInstance().pendienteDeValidacion().foreach(o -> o.convertir(conversor))
    public void convertir(Conversor conversor) {
        this.midi = conversor.convertir(audio);
        notificar("Fin de conversion");
        this.estadoOrden == EstadoOrden.PENDIENTE_VALIDACION;
    }

    @Override
    public int precio() {
        return this.audio.length;
    }

    @Override
    public int tiempoEntrega() {
        return 15;
    }

    @Override
    public EstadoValidacion estado() {
        return this.estadoValidacion;
    }

    public void validar() {
        this.estadoValidacion = EstadoValidacion.ACEPTADA;
        notificar("Melodia aceptada");
    }

    public void rechazar() {
        this.estadoValidacion = EstadoValidacion.RECHAZADA;
        notificar("Melodia rechazada");
    }
}
