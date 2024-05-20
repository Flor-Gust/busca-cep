package com.flor.primeirotesteapicep.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.primeirotesteapicep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.request.Request;
import com.flor.primeirotesteapicep.service.impl.EnderecoServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/v1/consulta-endereco")
@Tag(name = "Busca CEP", description = "Endpoint para buscar endereço por CEP.")
public class EnderecoController { 

    @Autowired
    private EnderecoServiceImpl service;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Busca endereço e calcula frete do CEP informado",
        description = "Busca endereço e calcula frete do CEP informado",
        tags = {"Busca CEP"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content()),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        }
    )
    public ResponseEntity<EnderecoDTO> obterCepViaBody(
        @RequestBody @Schema(example = "{\"cep\": \"01001000\"}") Request cep) 
    {
        EnderecoDTO dto = service.obterCep(cep.getCep());
        return ResponseEntity.ok().body(dto);
    }

}
