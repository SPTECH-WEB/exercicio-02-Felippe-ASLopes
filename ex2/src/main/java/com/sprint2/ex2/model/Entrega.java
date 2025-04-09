package com.sprint2.ex2.model;

public class Entrega {

    private Double peso;
    private String transportadora;

    public Entrega(Double peso, String transportadora) {
        this.peso = peso;
        this.transportadora = transportadora;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }
}
