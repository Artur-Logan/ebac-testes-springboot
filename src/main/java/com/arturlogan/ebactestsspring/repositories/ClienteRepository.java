package com.arturlogan.ebactestsspring.repositories;

import com.arturlogan.ebactestsspring.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
