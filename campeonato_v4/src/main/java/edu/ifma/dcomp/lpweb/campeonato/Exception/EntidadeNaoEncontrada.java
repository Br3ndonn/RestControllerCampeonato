package edu.ifma.dcomp.lpweb.campeonato.Exception;

public class EntidadeNaoEncontrada {
    private String mensagem;

    public EntidadeNaoEncontrada(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
