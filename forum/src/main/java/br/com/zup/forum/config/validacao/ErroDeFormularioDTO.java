package br.com.zup.forum.config.validacao;

public class ErroDeFormularioDTO {

    private String campo;

    private String erro;

    public ErroDeFormularioDTO(String field, String mensagem) {
        this.campo = field;
        this.erro = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
