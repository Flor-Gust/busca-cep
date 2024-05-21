package com.flor.primeirotesteapicep.domains.buscacep.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcecaoDeCepNaoEncontrado extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcecaoDeCepNaoEncontrado (String ex){
        super(ex);
    }
}
