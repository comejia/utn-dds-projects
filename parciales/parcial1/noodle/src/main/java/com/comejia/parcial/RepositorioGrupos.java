package com.comejia.parcial;

import java.util.List;

public class RepositorioGrupos {
    List<Grupo> grupos;

    public void crearGrupos(int cantidad, int tamIdeal) {
        for (int i = 0; i < cantidad; i++) {
            this.grupos.add(new Grupo(tamIdeal));
        }
    }
}
