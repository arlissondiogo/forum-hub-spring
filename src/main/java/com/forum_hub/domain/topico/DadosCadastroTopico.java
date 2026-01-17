package com.forum_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotBlank(message = "{titulo.obrigatorio}")
        String titulo,

        @NotBlank(message = "{mensagem.obrigatorio}")
        String mensagem,

        @NotNull(message = "{autor.obrigatorio}")
        String autorId,

        @NotNull(message = "{curso.obrigatorio}")
        String cursoId

) {
}
