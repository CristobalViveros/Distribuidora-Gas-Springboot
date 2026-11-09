package com.example.distribuidoraGas.repository;

import com.example.distribuidoraGas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}