package com.sprint2.ex2.strategy;

public class EntregaExpressaStrategy  implements EntregaStrategy{

    @Override
    public double calcularFrete(double peso) {
        return peso * 3.0;
    }
}
