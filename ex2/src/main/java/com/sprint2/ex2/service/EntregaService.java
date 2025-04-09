package com.sprint2.ex2.service;

import com.sprint2.ex2.adapter.TransportadoraExternaAdapter;
import com.sprint2.ex2.external.TransportadoraExternaAPI;
import com.sprint2.ex2.observer.EmailObserver;
import com.sprint2.ex2.observer.EntregaObserver;
import com.sprint2.ex2.observer.SmsObserver;
import com.sprint2.ex2.strategy.EntregaEconomicaStrategy;
import com.sprint2.ex2.strategy.EntregaExpressaStrategy;
import com.sprint2.ex2.strategy.EntregaStrategy;
import com.sprint2.ex2.strategy.TransportadoraTerceirizadaStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntregaService {

    private List<EntregaObserver> observadores;

    public EntregaService() {
        this.observadores = new ArrayList<>();
        this.observadores.add(new EmailObserver());
        this.observadores.add(new SmsObserver());
    }

    public double calcularFrete(double peso, String transportadora) {

        EntregaStrategy strategy;

        switch (transportadora.toLowerCase()) {
            case "expressa":
                strategy = new EntregaExpressaStrategy();
                break;
            case "economica":
                strategy = new EntregaEconomicaStrategy();
                break;
            case "terceirizada":
                strategy = new TransportadoraTerceirizadaStrategy();
                break;
            case "externa":
                return new TransportadoraExternaAdapter(new TransportadoraExternaAPI()).calcularFrete(peso);
            default:
                throw new IllegalArgumentException("Transportadora inválida.");
        }

        return strategy.calcularFrete(peso);
    }

    public void concluirEntrega() {
        observadores.forEach(obs -> obs.notificar("Entrega concluida."));
    }
}
