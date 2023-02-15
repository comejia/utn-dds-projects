package com.comejia.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recomendador {
    List<Criterio> criterios;

    public List<Contenido> sugerencias(Usuario usuario) {
        List<Contenido> contenidos;
        if (usuario.getPerfil() == Perfil.KIDS) {
            contenidos = RepositorioContenidos.instance().getContenidos().stream()
                    .filter(Contenido::aptoTodoPublico)
                    .collect(Collectors.toList());
        } else {
            contenidos = RepositorioContenidos.instance().getContenidos();
        }
        contenidos.removeAll(usuario.getContenidosVistos());
        List<Contenido> recomendados = new ArrayList<>();
        this.criterios.forEach(criterio -> recomendados.addAll(criterio.sugerencias(contenidos, usuario)));

        return recomendados;
    }

    public void agregarCriterio(Criterio criterio) {
        this.criterios.add(criterio);
    }

}
