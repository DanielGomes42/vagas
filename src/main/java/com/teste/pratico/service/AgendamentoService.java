package com.teste.pratico.service;


import com.teste.pratico.Repositorio.AgendamentoR;
import com.teste.pratico.Repositorio.VagaR;
import com.teste.pratico.viewprincipais.Agendamento;
import com.teste.pratico.viewprincipais.Solicitante;
import com.teste.pratico.viewprincipais.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoR agendamentoRepository;

    @Autowired
    private VagaR vagaRepository;

    public void agendar(Agendamento agendamento) {
        Vaga vaga = agendamento.getVaga();
        long totalAgendamentos = agendamentoRepository.countByVaga(vaga);

        if (totalAgendamentos >= vaga.getQuantidadeVagas()) {
            throw new IllegalStateException("Não há vagas disponíveis.");
        }

        agendamentoRepository.save(agendamento);
    }

    public List<AgendamentoR> consultarAgendamentos(LocalDate inicio, LocalDate fim, Solicitante solicitante) {
        return agendamentoRepository.findByDataAgendamentoBetweenAndSolicitante(inicio, fim, solicitante);
    }
}
