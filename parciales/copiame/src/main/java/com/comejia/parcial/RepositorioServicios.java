package com.comejia.parcial;

import java.util.List;

public class RepositorioServicios {
    List<Servicio> servicios;

    private static final RepositorioServicios instance = new RepositorioServicios();

    public static RepositorioServicios getInstance() {
        return instance;
    }

    public List<Servicio> getServicios() {
        return this.servicios;
    }
}
