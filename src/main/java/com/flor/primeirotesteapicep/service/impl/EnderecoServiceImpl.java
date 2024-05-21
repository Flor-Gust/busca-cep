package com.flor.primeirotesteapicep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.model.Endereco;
import com.flor.primeirotesteapicep.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{

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
