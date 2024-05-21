package com.flor.primeirotesteapicep.domains.buscacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.primeirotesteapicep.config.swagger.SwaggerCep;
import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.domains.buscacep.input.Request;
import com.flor.primeirotesteapicep.domains.buscacep.usecases.ValidarCep;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class EnderecoController implements SwaggerCep{ 

    @Autowired
    private ValidarCep usecase;

    public ResponseEntity<EnderecoDTO> obterCepViaBody(@RequestBody Request cep) 
    {
        EnderecoDTO dto = usecase.execute(cep.getCep());
        return ResponseEntity.ok().body(dto);
    }

}
