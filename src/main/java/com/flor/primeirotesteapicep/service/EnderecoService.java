package com.flor.primeirotesteapicep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.excecoes.ExcecaoDeMalRequerimento;
import com.flor.primeirotesteapicep.model.Endereco;

@Service
public class EnderecoService {

    @Autowired
    WebClient webClient;

    public EnderecoDTO obterCep(String cep){

        if(!isValidCep(cep.replace("-", ""))){
            throw new ExcecaoDeMalRequerimento("O formato do CEP informado está inválido!");
        } 

        String viaCepUrl = cep + "/json"; 
        
        Endereco end = webClient.get()
              .uri(viaCepUrl)
              .retrieve()
              .bodyToMono(Endereco.class)
              .block();

        if(end.getCep() == null){
            throw new ExcecaoDeCepNaoEncontrado("CEP informado não existe!!");
        }
        EnderecoDTO endDTO = new EnderecoDTO(end);
        return endDTO;
    }
    
    private boolean isValidCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }
}
