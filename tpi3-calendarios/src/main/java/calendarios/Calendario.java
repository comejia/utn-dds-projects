package calendarios;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Calendario {

  private final List<Evento> eventos;

  public Calendario() {
    this.eventos = new ArrayList<>();
  }

  // TODO implementar estado, comportamiento y/o polimorfismo según sea neceario

  public void agendar(Evento evento) {
    this.eventos.add(evento);
  }

  public boolean estaAgendado(Evento evento) {
    return this.eventos.contains(evento);
  }

  public List<Evento> eventosEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
    return eventos.stream()
        .filter(evento -> evento.estaEntre(inicio, fin))
        .collect(Collectors.toList());
  }

  public List<Evento> eventosSolapadosCon(Evento evento) {
    return this.eventos.stream()
        .filter(e -> e.estaSolapadoCon(evento))
        .collect(Collectors.toList());
  }

  public void agendarConRepeticion(Evento evento, LocalDateTime limite, Duration periodo) {
    agendar(evento);
    Evento repetido = evento.repetir(periodo);
    while (repetido.getInicio().isBefore(limite)) {
      agendar(repetido);
      repetido = repetido.repetir(periodo);
    }
  }
}
