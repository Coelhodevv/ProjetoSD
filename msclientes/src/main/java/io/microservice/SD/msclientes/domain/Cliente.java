package io.microservice.SD.msclientes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor // Usamos o consttutor sem argumentos nas entidades jpa porque qunado fomos fazer a
                    // pesquisa no banco, caso o jpa não encontre vai da erro,pois ele não vai conseguir
                    // instanciar via reflexion(biblioteca que ele usa para fazer instanciação dinamica)

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Column
    private Integer idade;

    public Cliente(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}
