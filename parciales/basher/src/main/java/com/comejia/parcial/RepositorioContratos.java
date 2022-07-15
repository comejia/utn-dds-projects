package com.comejia.parcial;

import java.util.List;

public class RepositorioContratos {
    List<Contrato> contratos;

    private static final RepositorioContratos instance = new RepositorioContratos();

    public static RepositorioContratos getInstance() {
        return instance;
    }
    public List<Contrato> getContratos() {
        return this.contratos;
    }
}
