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

	public <S extends Producto> S guardar(S entity) {
		return productoRepository.save(entity);
	}
	
	public List<Producto> obtenerTodos(){
		return productoRepository.findAll();
	}
	
	public Producto obtenerProducto(Integer id) {
		return productoRepository.getReferenceById(id);
	}
	
	public <S extends Producto> S actualizar(S entity) {
		return productoRepository.save(entity);
	}
	
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);
	}
}
