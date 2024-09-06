package io.microservice.SD.msavaliadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCliente {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;
}

// com isso conseguimos consultar os cartoes por clientes, indo pro microserviço de cartoes e em CartoesResource
// temos o metodo getCartoesByCliente que le retorna justamente esses atributos de CartaoCliente