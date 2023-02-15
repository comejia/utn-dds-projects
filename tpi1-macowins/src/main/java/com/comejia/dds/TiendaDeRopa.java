package com.comejia.dds;

import com.comejia.dds.venta.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TiendaDeRopa {

    private final List<Venta> ventas = new ArrayList<>();

    public void registrarVenta(Venta venta) {
        this.ventas.add(venta);
    }

    public Double gananciaDeUnDia(Date fecha) {
        return ventasDeUnDia(fecha)
                .stream()
                .mapToDouble(Venta::importe)
                .sum();
    }

    public List<Venta> ventasDeUnDia(Date fecha) {
        return this.ventas.stream()
                .filter(venta -> venta.esDeFecha(fecha))
                .collect(Collectors.toList());
    }
}
