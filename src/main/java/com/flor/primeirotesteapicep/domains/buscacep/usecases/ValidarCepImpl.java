package com.flor.primeirotesteapicep.domains.buscacep.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeMalRequerimento;
import com.flor.primeirotesteapicep.domains.buscacep.ports.EnderecoPorts;
import com.flor.primeirotesteapicep.domains.buscacep.resources.ValidarCep;

import lombok.Data;

@Component
@Data
public class ValidarCepImpl implements ValidarCep{

    @Autowired
    private EnderecoPorts service;

    @Override
    public EnderecoDTO execute(String cep) {
        if(!isValidCep(cep)){
            throw new ExcecaoDeMalRequerimento("O formato do CEP informado está inválido!");
        } 

        return service.obterCep(cep);
    }
    
    private boolean isValidCep(String cep) {
        return cep.matches("^\\d{5}-?\\d{3}$");
    }
}
