package com.teste.pratico.Repositorio;


import com.teste.pratico.viewprincipais.Agendamento;
import com.teste.pratico.viewprincipais.Solicitante;
import com.teste.pratico.viewprincipais.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AgendamentoR extends JpaRepository<Agendamento, Long> {

    List<AgendamentoR> findByDataAgendamentoBetweenAndSolicitante(LocalDate inicio, LocalDate fim, Solicitante solicitante);

    long countByVaga(Vaga vaga);
}