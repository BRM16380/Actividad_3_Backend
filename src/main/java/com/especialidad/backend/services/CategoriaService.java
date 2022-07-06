package com.especialidad.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.especialidad.backend.model.Categoria;
import com.especialidad.backend.model.Producto;
import com.especialidad.backend.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public <S extends Categoria> S guardar(S entity) {
		return categoriaRepository.save(entity);
	}
	
	public List<Categoria> obtenerTodos(){
		return categoriaRepository.findAll();
	}
	
	public Categoria obtenerCategoria(Integer id) {
		return categoriaRepository.getReferenceById(id);
	}
	
	public <S extends Categoria> S actualizar(S entity) {
		return categoriaRepository.save(entity);
	}
	
	public void eliminar(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
