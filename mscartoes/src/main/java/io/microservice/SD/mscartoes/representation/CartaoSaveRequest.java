package io.microservice.SD.mscartoes.representation;

import io.microservice.SD.mscartoes.domain.BandeiraCartao;
import io.microservice.SD.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){  // Transforma essa requisiçao em um objeto do tipo cartao
        return new Cartao(nome, bandeira, renda, limite );
    }
}


