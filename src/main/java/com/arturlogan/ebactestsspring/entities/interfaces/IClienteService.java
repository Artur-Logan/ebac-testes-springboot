package com.arturlogan.ebactestsspring.entities.interfaces;

import com.arturlogan.ebactestsspring.dto.request.ClienteRequest;
import com.arturlogan.ebactestsspring.dto.response.ClienteResponse;

import java.util.List;

public interface IClienteService {

    ClienteResponse salvar(ClienteRequest clienteRequest);
    void deletar(Long id);
    ClienteResponse obter(Long id);
    List<ClienteResponse> listarTodos();
}
