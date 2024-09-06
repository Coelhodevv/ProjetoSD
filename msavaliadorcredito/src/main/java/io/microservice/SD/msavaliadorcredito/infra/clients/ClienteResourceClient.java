package io.microservice.SD.msavaliadorcredito.infra.clients;


import io.microservice.SD.msavaliadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);

}

// O FeignClient é um Cliente HTTP, então a comunicação entre os microsserviços  vai acontecer via HTTp , Logo no
// nosso Avaliador de credito vamos receber uma requisição(@RequestParam("cpf)) e essa requisição vai despachar pro
// Service por meio do metodo obterSituaçãoCliente e esse Service vai fazer duas requisiçoes atrvés do metodo obterSituaçaoCliente
// que vai ser uma requisiçao para MSCLIENTES e outra para MSCARTOES; ou sja, ele como falamos é um Cliente HTTP e ele vem facilitar
// porque não precisamos implementar muita coisa porque ele já vem pronto e como ele é uma interface só fazemos a definição da assinatura da requisição e ele ja faz tudo pra gente

