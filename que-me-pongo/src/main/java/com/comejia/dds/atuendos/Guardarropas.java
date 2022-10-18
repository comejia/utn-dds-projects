package com.comejia.dds.atuendos;

import com.comejia.dds.prenda.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropas {

  private final List<Prenda> prendas;
  private final List<Propuesta> propuestas = new ArrayList<>();

  public Guardarropas(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public List<Atuendo> generarAtuendos() {
    return Arrays.asList(
        new Atuendo(generarParteSuperior(), generarParteInferior(), generarCalzado()),
        new Atuendo(generarParteSuperior(), generarParteInferior(), generarCalzado())
    );
  }

  public Prenda generarParteSuperior() {
    return this.prendas.stream()
        .filter(p -> p.categoria().equals(Categoria.PARTE_SUPERIOR))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No se encontraron prendas de la categoria Parte Superior"));
  }

  public Prenda generarParteInferior() {
    return this.prendas.stream()
        .filter(p -> p.categoria().equals(Categoria.PARTE_INFERIOR))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No se encontraron prendas de la categoria Parte Inferior"));
  }

  public Prenda generarCalzado() {
    return this.prendas.stream()
        .filter(p -> p.categoria().equals(Categoria.CALZADO))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No se encontraron prendas de la categoria Calzado"));
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void agregarPropuesta(Propuesta propuesta) {
    this.propuestas.add(propuesta);
  }

  public List<Propuesta> propuestasPendientes() {
    return this.propuestas.stream().filter(Propuesta::estaPendiente).collect(Collectors.toList());
  }

  public List<Propuesta> propuestasAceptadas() {
    return this.propuestas.stream().filter(Propuesta::estaAceptada).collect(Collectors.toList());
  }

}
