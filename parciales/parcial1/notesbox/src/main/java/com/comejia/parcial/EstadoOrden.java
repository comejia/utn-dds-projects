package com.comejia.parcial;

public enum EstadoOrden {

    PEDIDA {
        @Override
        public int tiempoEstimado(Fabrica fabrica) {
            return 2 + fabrica.tiempoFabricacion() ;
        }

    },
    PENDIENTE {
        @Override
        public int tiempoEstimado(Fabrica fabrica) {
            return 0;
        }
    },
    ASIGNADA {
        @Override
        public int tiempoEstimado(Fabrica fabrica) {
            return 0;
        }
    },
    FABRICANDO {
        @Override
        public int tiempoEstimado(Fabrica fabrica) {
            return fabrica.tiempoFabricacion();
        }
    },
    ENVIANDO {
        @Override
        public int tiempoEstimado(Fabrica fabrica) {
            return 0;
        }
    };

    public abstract int tiempoEstimado(Fabrica fabrica);
}
