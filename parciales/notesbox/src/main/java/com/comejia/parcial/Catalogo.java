package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {

    List<Melodia> melodias;

    // Requerimiento 1
    private static final Catalogo instance = new Catalogo();

    public static Catalogo getInstance() {
        return instance;
    }

    public List<Melodia> getMelodias() {
        return this.melodias;
    }

}
