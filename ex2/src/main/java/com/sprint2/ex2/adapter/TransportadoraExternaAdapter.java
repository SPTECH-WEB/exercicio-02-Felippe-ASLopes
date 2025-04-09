package com.sprint2.ex2.adapter;

import com.sprint2.ex2.external.TransportadoraExternaAPI;

public class TransportadoraExternaAdapter {

    private TransportadoraExternaAPI apiExterna;

    public TransportadoraExternaAdapter(TransportadoraExternaAPI apiExterna) {
        this.apiExterna = apiExterna;
    }

    public double calcularFrete(double peso){
        return apiExterna.calcularFrete(peso);
    }
}
