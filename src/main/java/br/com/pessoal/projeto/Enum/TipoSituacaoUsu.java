package br.com.pessoal.projeto.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/*
é uma forma de tornar a serialização de enums ou objetos Java mais estruturada e completa,
 permitindo que clientes
ou APIs tenham acesso a informações detalhadas, não apenas ao valor simples.
 Isso torna a comunicação
 via JSON mais rica e flexível.
 */
public enum TipoSituacaoUsu {
    ATIVO ("A", "Ativo"),
    INATIVO("I", "Inativo"),
    PENDENTE ("P", "Pendente");

    private String codigo;
    private  String descricao;


     TipoSituacaoUsu(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public static TipoSituacaoUsu doValor(String codigo) {
        String codigoFormatado = codigo.toUpperCase();
        if (codigoFormatado.equals("A")) {
            return TipoSituacaoUsu.ATIVO;
        } else if (codigoFormatado.equals("I")) {
            return TipoSituacaoUsu.INATIVO;
        }else {
            return TipoSituacaoUsu.PENDENTE;
        }
    }
}
