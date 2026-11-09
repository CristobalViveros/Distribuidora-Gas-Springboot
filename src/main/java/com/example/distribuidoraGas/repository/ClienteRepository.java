package com.example.distribuidoraGas.repository;

import com.example.distribuidoraGas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}