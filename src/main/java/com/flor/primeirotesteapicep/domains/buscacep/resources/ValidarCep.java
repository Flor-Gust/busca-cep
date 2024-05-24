package com.flor.primeirotesteapicep.domains.buscacep.resources;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;

public interface ValidarCep {
    EnderecoDTO execute(String cep);
}
