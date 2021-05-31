package br.com.zup.forum.dto.entrada;

import br.com.zup.forum.modelo.Curso;
import br.com.zup.forum.modelo.Topico;
import br.com.zup.forum.repository.CursoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    private String titulo;

    @NotNull @NotEmpty @Size(min = 10)
    private String mensagem;

    @NotNull @NotEmpty
    private String nomeCurso;

    public String getTitulo() { return titulo; }

    public String getMensagem() { return mensagem; }

    public String getNomeCurso() { return nomeCurso; }


    public Topico toTopico(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
