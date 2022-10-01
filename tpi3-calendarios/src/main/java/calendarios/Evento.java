package calendarios;

import calendarios.servicios.ShemailLib;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Evento {

  private String nombre;
  private LocalDateTime inicio;
  private LocalDateTime fin;
  private Ubicacion ubicacion;
  private final List<Usuario> invitados;
  private List<Duration> recordatorios;

  public Evento(String nombre,
                LocalDateTime inicio,
                LocalDateTime fin,
                Ubicacion ubicacion,
                List<Usuario> invitados) {

    this.nombre = nombre;
    this.inicio = inicio;
    this.fin = fin;
    this.ubicacion = ubicacion;
    this.invitados = invitados;
    this.recordatorios = new ArrayList<>();
  }

  // TODO implementar estado, comportamiento y/o polimorfismo según sea neceario

  public LocalDateTime getInicio() {
    return this.inicio;
  }

  public Duration cuantoFalta() {
    // Este es un ejemplo de cómo se puede obtener una duración
    // Modificar en caso de que sea necesario
    return Duration.ofMinutes(LocalDateTime.now().until(getInicio(), ChronoUnit.MINUTES));
  }

  public boolean estaSolapadoCon(Evento otro) {
    return this.inicio.isBefore(otro.fin) && otro.inicio.isBefore(this.fin);
  }

  public void agregarInvitado(Usuario invitado) {
    this.invitados.add(invitado);
  }

  public boolean tieneInvitado(Usuario invitado) {
    return this.invitados.contains(invitado);
  }

  public boolean estaEntre(LocalDateTime inicio, LocalDateTime fin) {
    return this.inicio.isAfter(inicio) && this.fin.isBefore(fin);
  }

  public Evento repetir(Duration frecuencia) {
    return new Evento(nombre, inicio.plus(frecuencia), fin.plus(frecuencia), ubicacion, invitados);

  }

  public Ubicacion getUbicacion() {
    return this.ubicacion;
  }

  public void agregarRecordatorio(Duration tiempoFaltante) {
    this.recordatorios.add(tiempoFaltante);
  }

  public void enviarRecordatorios(ShemailLib shemailLib, String mail) {
    this.recordatorios.forEach(recordatorio -> {
      if (cuantoFalta().minus(recordatorio).compareTo(Duration.ZERO) <= 0) {
        shemailLib.enviarMailA(mail, nombre, "Falta poco tiempo");
      }
    });
  }
}
