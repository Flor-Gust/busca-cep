package com.flor.primeirotesteapicep.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.excecoes.ExcecaoDeMalRequerimento;
import com.flor.primeirotesteapicep.service.EnderecoService;
import com.flor.primeirotesteapicep.usecases.ValidarCep;

@Component
public class ValidarCepImpl implements ValidarCep{

    @Autowired
    EnderecoService service;

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
