package com.example.distribuidoraGas.service;

import com.example.distribuidoraGas.model.Venta;
import com.example.distribuidoraGas.repository.VentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> obtenerTodos() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta guardar(Venta venta) {
        venta.setId(null);
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Long id, Venta datos) {
        return ventaRepository.findById(id).map(existente -> {
            existente.setClienteId(datos.getClienteId());
            existente.setProductoId(datos.getProductoId());
            existente.setCantidad(datos.getCantidad());
            existente.setTotal(datos.getTotal());
            existente.setMetodoPago(datos.getMetodoPago());
            existente.setDireccionEntrega(datos.getDireccionEntrega());
            existente.setEstado(datos.getEstado());
            existente.setFecha(datos.getFecha());
            return ventaRepository.save(existente);
        });
    }

    public boolean eliminar(Long id) {
        if (!ventaRepository.existsById(id)) {
            return false;
        }
        ventaRepository.deleteById(id);
        return true;
    }
}