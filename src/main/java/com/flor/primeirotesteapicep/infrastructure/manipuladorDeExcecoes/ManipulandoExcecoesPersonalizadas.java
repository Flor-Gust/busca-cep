package com.flor.primeirotesteapicep.infrastructure.manipuladorDeExcecoes;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeCepNaoEncontrado;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoDeMalRequerimento;
import com.flor.primeirotesteapicep.domains.buscacep.excecoes.ExcecaoPersonalizada;


@ControllerAdvice
@RestController
public class ManipulandoExcecoesPersonalizadas extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
	public final ResponseEntity<ExcecaoPersonalizada> handleAllExceptions(Exception ex, WebRequest request) {
		ExcecaoPersonalizada excecaoPersonalizada = new ExcecaoPersonalizada(
				new Date(),
				"Ocorreu uma falha interna",
				request.getDescription(false)
		);
		return new ResponseEntity<>(excecaoPersonalizada, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ExcecaoDeMalRequerimento.class)
	public final ResponseEntity<ExcecaoPersonalizada> handleBadRequestExceptions(ExcecaoDeMalRequerimento ex, WebRequest request) {
		ExcecaoPersonalizada excecaoPersonalizada = new ExcecaoPersonalizada(
				new Date(),
				ex.getMessage(), 
				request.getDescription(false)
		);
		return new ResponseEntity<>(excecaoPersonalizada, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ExcecaoDeCepNaoEncontrado.class)
	public final ResponseEntity<ExcecaoPersonalizada> handleBadRequestExceptions(ExcecaoDeCepNaoEncontrado ex, WebRequest request) {
		ExcecaoPersonalizada excecaoPersonalizada = new ExcecaoPersonalizada(
				new Date(),
				ex.getMessage(), 
				request.getDescription(false)
		);
		return new ResponseEntity<>(excecaoPersonalizada, HttpStatus.NOT_FOUND);
	}
}
