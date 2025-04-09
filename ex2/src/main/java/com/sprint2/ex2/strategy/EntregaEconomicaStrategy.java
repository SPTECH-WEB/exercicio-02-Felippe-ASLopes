package com.sprint2.ex2.strategy;

public class EntregaEconomicaStrategy implements EntregaStrategy{

    @Override
    public double calcularFrete(double peso) {
        return peso * 1.5;
    }
}
