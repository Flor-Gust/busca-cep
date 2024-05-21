package com.flor.primeirotesteapicep.dto;

import java.io.Serializable;

import com.flor.primeirotesteapicep.enums.Estado;
import com.flor.primeirotesteapicep.model.Endereco;
import lombok.Data;

@Data
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

    public Double recuperaFrete() {
        return Estado.valueOf(estado).getValue();
    }
}
