package com.sprint2.ex2.controller;

import com.sprint2.ex2.model.Entrega;
import com.sprint2.ex2.service.EntregaService;
import com.sprint2.ex2.strategy.EntregaStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public String calcularFrete(@RequestBody Entrega entrega) {

        double valorFrete = entregaService.calcularFrete(entrega.getPeso(), entrega.getTransportadora());
        entregaService.concluirEntrega();

        return "Frete calculado: " + valorFrete;
    }
}
