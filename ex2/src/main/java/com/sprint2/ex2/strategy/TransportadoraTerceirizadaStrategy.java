package com.sprint2.ex2.strategy;

public class TransportadoraTerceirizadaStrategy implements EntregaStrategy {

    @Override
    public double calcularFrete(double peso) {
        return peso * 5.0;
    }
}
