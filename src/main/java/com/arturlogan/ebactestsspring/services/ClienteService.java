package com.arturlogan.ebactestsspring.services;

import com.arturlogan.ebactestsspring.dto.request.ClienteRequest;
import com.arturlogan.ebactestsspring.dto.response.ClienteResponse;
import com.arturlogan.ebactestsspring.entities.Cliente;
import com.arturlogan.ebactestsspring.entities.interfaces.IClienteService;
import com.arturlogan.ebactestsspring.mappers.ClienteMapper;
import com.arturlogan.ebactestsspring.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    @Override
    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toModel(clienteRequest);
        clienteRepository.save(cliente);

        return clienteMapper.toResponse(cliente);
    }

    @Override
    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        clienteRepository.delete(cliente);
    }

    @Override
    public ClienteResponse obter(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();

        return clienteMapper.toResponse(cliente);
    }

    @Override
    public List<ClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }
}
