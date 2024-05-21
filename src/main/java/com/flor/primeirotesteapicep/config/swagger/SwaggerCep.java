package com.flor.primeirotesteapicep.config.swagger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.domains.buscacep.input.Request;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Busca CEP", description = "Endpoint para buscar endereço por CEP.")
public interface SwaggerCep {
    
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
    ResponseEntity<EnderecoDTO> obterCepViaBody(
        @RequestBody @Schema(example = "{\"cep\": \"01001-000\"}") Request cep);
}
