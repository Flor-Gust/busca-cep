package com.flor.primeirotesteapicep.dto;

import java.io.Serializable;

import com.flor.primeirotesteapicep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.model.Endereco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;

    public EnderecoDTO(Endereco end){
        this.cep = end.getCep();
        this.rua = end.getLogradouro();
        this.complemento = end.getComplemento();
        this.bairro = end.getBairro();
        this.cidade = end.getLocalidade();
        this.estado = end.getUf();
        this.frete = recuperaFrete();
    }

    public Double recuperaFrete(){
        if ("SP".equals(estado) || "MG".equals(estado) || "RJ".equals(estado) || "ES".equals(estado)) {
            return 7.85;
        } else if ("PR".equals(estado) || "SC".equals(estado) || "RS".equals(estado)) {
            return 17.30;
        } else if ("MT".equals(estado) || "GO".equals(estado) || "MS".equals(estado)) {
            return 12.50;
        } else if ("MA".equals(estado) || "PI".equals(estado) || "CE".equals(estado) || "RN".equals(estado) || "PB".equals(estado) || "PE".equals(estado) || "AL".equals(estado) || "SE".equals(estado) || "BA".equals(estado)) {
            return 15.98;
        } else if ("AC".equals(estado) || "RO".equals(estado) || "AM".equals(estado) || "RR".equals(estado) || "PA".equals(estado) || "AP".equals(estado) || "TO".equals(estado)) {
            return 20.83;
        } else {
            throw new ExcecaoDeCepNaoEncontrado("CEP informado não existe!!");
        }
    }
}
