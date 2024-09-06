package io.microservice.SD.msclientes.application.representation;

import io.microservice.SD.msclientes.domain.Cliente;
import lombok.Data;

@Data // Para criar os gets e settrs
public class ClienteSaveRequest {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){ // esse metodo ele vai converter esse objeto ClienteSaveRequest que é representacional do JSON em um cliente realmente que é nossa entidade
        return new Cliente(nome, cpf, idade);
    }
}
