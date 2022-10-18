package com.comejia.dds.clima;

public enum AlertaMeteorologica {
  TORMENTA {
    @Override
    public String getMensaje() {
      return "Sali con paraguas!";
    }
  },
  GRANIZO {
    @Override
    public String getMensaje() {
      return "No uses el auto";
    }
  };

  abstract public String getMensaje();
}
