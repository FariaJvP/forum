package br.com.zup.forum.dto.entrada;

import br.com.zup.forum.modelo.Topico;
import br.com.zup.forum.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AtualizaTopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Size(min = 10)
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Topico atualiza(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.atualiza(this.titulo, this.mensagem);
        return topico;
    }
}
