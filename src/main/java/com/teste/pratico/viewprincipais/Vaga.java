package com.teste.pratico.viewprincipais;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int quantidadeVagas;

    public long getQuantidadeVagas() {
        return 0;
    }

    // Getters e Setters
}