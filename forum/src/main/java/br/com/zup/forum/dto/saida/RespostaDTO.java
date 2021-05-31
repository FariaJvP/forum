package br.com.zup.forum.dto.saida;

import br.com.zup.forum.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDTO {

    private Long id;
    private String messagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;


    public RespostaDTO(Resposta resposta) {
        this.id = resposta.getId();
        this.messagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMessagem() {
        return messagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
