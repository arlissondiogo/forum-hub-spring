package com.forum_hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private String status;

    @Column(name = "autor_id")
    private String autorId;

    @Column(name = "curso_id")
    private String cursoId;

    private Boolean ativo;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autorId = dados.autorId();
        this.cursoId = dados.cursoId();
        this.status = "NAO_RESPONDIDO";
        this.dataCriacao = LocalDateTime.now();
        this.ativo = true;
    }


    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.autorId() != null) {
            this.autorId = dados.autorId();
        }
        if (dados.cursoId() != null) {
            this.cursoId = dados.cursoId();
        }
    }
}
