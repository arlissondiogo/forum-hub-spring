package com.forum_hub.domain.topico;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, String autorId, String cursoId) {
    public DadosDetalhamentoTopico (Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getAutorId(), topico.getCursoId());
    }
}
