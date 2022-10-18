package com.comejia.dds.prenda;

public enum TipoDePrenda {

  ZAPATOS {
    @Override
    public Categoria categoria() {
      return Categoria.CALZADO;
    }

    @Override
    public boolean aptoParaTemperatura(int temperatura) {
      return temperatura < 35;
    }
  },
  CAMISA_MANGA_CORTA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }

    @Override
    public boolean aptoParaTemperatura(int temperatura) {
      return temperatura >= 25;
    }

  },
  PANTALON {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_INFERIOR;
    }

    @Override
    public boolean aptoParaTemperatura(int temperatura) {
      return temperatura < 30;
    }
  },
  CHOMBA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }

    @Override
    public boolean aptoParaTemperatura(int temperatura) {
      return temperatura >= 20;
    }
  },
  ZAPATILLAS {
    @Override
    public Categoria categoria() {
      return Categoria.CALZADO;
    }

    @Override
    public boolean aptoParaTemperatura(int temperatura) {
      return temperatura < 38;
    }
  };

  public abstract Categoria categoria();

  public abstract boolean aptoParaTemperatura(int temperatura);

}
