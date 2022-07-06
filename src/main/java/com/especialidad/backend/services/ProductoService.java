package com.especialidad.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.especialidad.backend.model.Producto;
import com.especialidad.backend.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public List<Producto> obtenerTodos(){
		return productoRepository.findAll();
	}
	
	public Producto obtenerProducto(Integer id) {
		return productoRepository.getReferenceById(id);
	}
	
	public void actualizar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);
	}
}
