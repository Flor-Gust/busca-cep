package com.flor.primeirotesteapicep.domains.buscacep.ports;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;

public interface EnderecoPorts {
    public EnderecoDTO obterCep(String cep);   
}
