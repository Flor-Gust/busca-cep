package com.flor.primeirotesteapicep.usecases;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;

public interface ValidarCep {
    EnderecoDTO execute(String cep);
}
