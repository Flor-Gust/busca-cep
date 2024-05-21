package com.flor.primeirotesteapicep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.request.Request;
import com.flor.primeirotesteapicep.swagger.SwaggerCep;
import com.flor.primeirotesteapicep.usecases.ValidarCep;

import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class EnderecoController implements SwaggerCep{ 

    @Autowired
    private ValidarCep usecase;

    public ResponseEntity<EnderecoDTO> obterCepViaBody(@RequestBody @Schema(example = "{\"cep\": \"01001000\"}") Request cep) 
    {
        EnderecoDTO dto = usecase.execute(cep.getCep());
        return ResponseEntity.ok().body(dto);
    }

}
