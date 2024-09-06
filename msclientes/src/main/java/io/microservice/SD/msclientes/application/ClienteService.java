package io.microservice.SD.msclientes.application;

import io.microservice.SD.msclientes.domain.Cliente;
import io.microservice.SD.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor // é a mesma coisa de criar o construtor com essa dependencia:  public ClienteService(ClienteRepository repository) {
 //                                                                                      this.repository = repository; }
public class ClienteService { // aqui são nossos 2 endpoints

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){ // colocamos um Optional pois possa ser que exista ou nao um cliente para aquele cpf que eles esteja buscando
        return repository.findByCpf(cpf);
    }
    }
