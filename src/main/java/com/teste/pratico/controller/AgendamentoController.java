package com.teste.pratico.controller;


import com.teste.pratico.Repositorio.AgendamentoR;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.viewprincipais.Agendamento;
import com.teste.pratico.viewprincipais.Solicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<String> agendar(@RequestBody Agendamento agendamento) {
        agendamentoService.agendar(agendamento);
        return ResponseEntity.ok("Agendamento realizado com sucesso.");
    }

    @GetMapping
    public List<AgendamentoR> listarAgendamentos(@RequestParam LocalDate inicio, @RequestParam LocalDate fim, @RequestParam Solicitante solicitante) {
        return agendamentoService.consultarAgendamentos(inicio, fim, solicitante);
    }
}
