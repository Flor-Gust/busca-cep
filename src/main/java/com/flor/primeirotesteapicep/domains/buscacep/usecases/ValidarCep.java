package com.flor.primeirotesteapicep.domains.buscacep.usecases;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;

public interface ValidarCep {
    EnderecoDTO execute(String cep);
}
