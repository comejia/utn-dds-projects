package com.comejia.parcial;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDescargas {
    List<Descarga> descargas;

    public void ingresarDescarga(Descarga descarga) {
        this.descargas.add(descarga);
        asociar(descarga);
    }

    public void asociar(Descarga descarga) {
        List<Contrato> contratosCompatibles =  RepositorioContratos.getInstance().getContratos().stream()
                .filter(c -> c.esCompatible(descarga.getCliente(), descarga.getTipoGrano()))
                .collect(Collectors.toList());
        //Contrato prioritario = contratosCompatibles.stream().sorted(Comparator.comparing(Contrato::esPrioritario)).collect(Collectors.toList());
        //Collections.sort(contratosCompatibles.stream().map(a -> a.), (a, b) -> a.fechaVencimiento() < b.fechaVencimiento());
        descarga.agregarContrato(contratosCompatibles.stream().findFirst().get());
    }


}
