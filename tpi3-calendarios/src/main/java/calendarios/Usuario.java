package calendarios;

import calendarios.servicios.GugleMapas;
import calendarios.servicios.PositionService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Usuario {

  private String email;
  private final List<Calendario> calendarios;
  private PositionService positionService;
  private GugleMapas gugleMapas;

  public Usuario(String email, PositionService positionService, GugleMapas gugleMapas) {
    this.email = email;
    this.positionService = positionService;
    this.gugleMapas = gugleMapas;
    this.calendarios = new ArrayList<>();
  }

  // TODO implementar estado, comportamiento y/o polimorfismo según sea neceario

  public void agregarCalendario(Calendario calendario) {
    this.calendarios.add(calendario);
  }

  public List<Evento> eventosEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
    return this.calendarios.stream()
        .map(calendario -> calendario.eventosEntreFechas(inicio, fin))
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public boolean llegaATiempoAlProximoEvento() {
    List<Evento> eventos =
        eventosEntreFechas(LocalDateTime.now(), LocalDateTime.now().plusYears(1));

    if (eventos.isEmpty()) {
      return true;
    }

    Evento proximo = eventos.stream()
        .min(Comparator.comparing(Evento::cuantoFalta))
        .orElseThrow(RuntimeException::new);
    Ubicacion partida = positionService.ubicacionActual(this.email);
    Ubicacion llegada = proximo.getUbicacion();

    return gugleMapas.tiempoEstimadoHasta(partida, llegada).compareTo(proximo.cuantoFalta()) <= 0;
  }

  public boolean tieneCalendario(Calendario calendario) {
    return this.calendarios.contains(calendario);
  }

  public String email() {
    return this.email;
  }
}
