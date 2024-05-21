package com.flor.primeirotesteapicep.domains.buscacep.excecoes;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcecaoPersonalizada implements Serializable{

    private static final long serialVersionUID = 1L;

    private Date horario;
    private String mensagem;
    private String detalhes;
}
