package com.flor.primeirotesteapicep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.request.Request;
import com.flor.primeirotesteapicep.service.impl.EnderecoServiceImpl;
import com.flor.primeirotesteapicep.swagger.SwaggerCep;

import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class EnderecoController implements SwaggerCep{ 

    @Autowired
    private EnderecoServiceImpl service;

    public ResponseEntity<EnderecoDTO> obterCepViaBody(@RequestBody @Schema(example = "{\"cep\": \"01001000\"}") Request cep) 
    {
        EnderecoDTO dto = service.obterCep(cep.getCep());
        return ResponseEntity.ok().body(dto);
    }

}
