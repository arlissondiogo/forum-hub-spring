package com.forum_hub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(String titulo,
                                   String mensagem,
                                   String status,
                                   String autorId,
                                   String cursoId,
                                   LocalDateTime dataCriacao
                                   ) {

    public DadosListagemTopicos (Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getStatus(),topico.getAutorId(), topico.getCursoId(),topico.getDataCriacao());
    }
}
