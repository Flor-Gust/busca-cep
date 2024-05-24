package com.flor.primeirotesteapicep.domains.buscacep.resources;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.flor.primeirotesteapicep.domains.buscacep.dto.EnderecoDTO;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeMalRequerimento;
import com.flor.primeirotesteapicep.domains.buscacep.ports.EnderecoPorts;
import com.flor.primeirotesteapicep.domains.buscacep.usecases.ValidarCepImpl;

class ValidarCepImplTest {

    @Mock
    private EnderecoPorts enderecoPorts;

    private ValidarCepImpl validarCep;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validarCep = new ValidarCepImpl();
        validarCep.setService(enderecoPorts);
    }

    @Test
    void testExecute_ValidCep_ReturnsEnderecoDTO() {
        String cep = "12345-678";
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        when(enderecoPorts.obterCep(cep)).thenReturn(enderecoDTO);

        EnderecoDTO result = validarCep.execute(cep);

        assertEquals(enderecoDTO, result);
        verify(enderecoPorts, times(1)).obterCep(cep);
    }

    @Test
    void testExecute_InvalidCep_ThrowsExcecaoDeMalRequerimento() {
        String cep = "12345678a";

        assertThrows(ExcecaoDeMalRequerimento.class, () -> validarCep.execute(cep));
    }

    @Test
    void testExecute_NullCep_ThrowsExcecaoDeCepNaoExiste() {
        String cepNaoExistente = "13880000";
        when(enderecoPorts.obterCep(cepNaoExistente)).thenThrow(ExcecaoDeCepNaoEncontrado.class);

        assertThrows(ExcecaoDeCepNaoEncontrado.class, () -> enderecoPorts.obterCep(cepNaoExistente));
    }
}