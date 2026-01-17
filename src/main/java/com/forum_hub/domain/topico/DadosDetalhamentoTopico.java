package com.forum_hub.domain.topico;

import java.util.TimerTask;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, String autor, String curso) {
    public DadosDetalhamentoTopico (Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getAutorId(), topico.getCursoId());
    }
}
