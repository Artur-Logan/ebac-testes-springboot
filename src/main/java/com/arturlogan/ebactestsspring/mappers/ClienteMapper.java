package com.arturlogan.ebactestsspring.mappers;

import com.arturlogan.ebactestsspring.entities.Cliente;
import com.arturlogan.ebactestsspring.dto.request.ClienteRequest;
import com.arturlogan.ebactestsspring.dto.response.ClienteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toModel(ClienteRequest clienteRequest);
    ClienteResponse toResponse(Cliente cliente);
}
