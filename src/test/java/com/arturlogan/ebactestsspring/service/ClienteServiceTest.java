package com.arturlogan.ebactestsspring.service;

import com.arturlogan.ebactestsspring.dto.request.ClienteRequest;
import com.arturlogan.ebactestsspring.dto.response.ClienteResponse;
import com.arturlogan.ebactestsspring.entities.Cliente;
import com.arturlogan.ebactestsspring.mappers.ClienteMapper;
import com.arturlogan.ebactestsspring.repositories.ClienteRepository;
import com.arturlogan.ebactestsspring.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @SpyBean
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

//    @Autowired
//    @MockBean
//    private ClienteResponse clienteResponse;

//    @Test
//    void salvarSucesso(){
//        //cenario
//        ClienteRequest clienteRequest = getClienteRequest();
//
//        Cliente cliente = new Cliente();
//        cliente.setNome("Cliente Teste");
//        cliente.setIdade(1);
//
//        //execução
//        when(clienteRepository.save(Mockito.any()))
//                .thenReturn(cliente);
//
//        //verificação
//        assertEquals(clienteRequest.getNome(), cliente.getNome());
//        assertEquals(clienteRequest.getIdade(), cliente.getIdade());
//    }

    @Test
    void obterSucesso(){
        //cenario
        Long id = 1L;

        Cliente cliente = getCliente(id);

        when(clienteRepository.findById(any()))
                .thenReturn(Optional.ofNullable(cliente));

        //execução
        ClienteResponse clienteResponse = clienteService.obter(id);

        //verificação
        assertEquals(id, clienteResponse.getId());
    }

//    @Test
//    void deletarSucesso(){
//        //cenario
//        Long id = 1L;
//
//        when(clienteRepository.findById(any()))
//                .thenReturn(Optional.of(getCliente(id)));
//
//        //execução
//        clienteService.deletar(id);
//    }
//
//    @Test
//    void listarTodos(){
//        //cenario
//        Cliente cliente1 = getCliente(1L);
//        Cliente cliente2 = getCliente(2L);
//        Cliente cliente3 = getCliente(3L);
//
//        List<Cliente> clienteList = List.of(
//                cliente1, cliente2, cliente3
//        );
//
//        when(clienteRepository.findAll())
//                .thenReturn(clienteList);
//
//        //execução
//        List<ClienteResponse> clienteResponses = clienteService.listarTodos();
//
//        //verificação
//        assertTrue(clienteList.size() > 0);
//        assertEquals(3, clienteList.size());
//    }

    private ClienteRequest getClienteRequest(){
        ClienteRequest clienteRequest = new ClienteRequest();

        clienteRequest.setNome("Cliente Teste");
        clienteRequest.setIdade(1);

        return clienteRequest;
    }

    public Cliente getCliente(Long id){
        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNome("Cliente Entity Teste");
        cliente.setIdade(10);

        return cliente;
    }
}
