package com.flor.primeirotesteapicep.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.domains.buscacep.model.Endereco;
import com.flor.primeirotesteapicep.domains.buscacep.ports.EnderecoPorts;


@Service
public class EnderecoAdapter implements EnderecoPorts{

    @Autowired
    private WebClient webClient;

    public EnderecoDTO obterCep(String cep){
        String viaCepUrl = cep + "/json"; 
        
        Endereco end = webClient.get()
              .uri(viaCepUrl)
              .retrieve()
              .bodyToMono(Endereco.class)
              .block();

        if(end.getCep() == null){
            throw new ExcecaoDeCepNaoEncontrado("CEP informado não existe!!");
        }

        return new EnderecoDTO(end);
    }
}