package com.especialidad.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.especialidad.backend.model.Categoria;
import com.especialidad.backend.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public void guardar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> obtenerTodos(){
		return categoriaRepository.findAll();
	}
	
	public Categoria obtenerCategoria(Integer id) {
		return categoriaRepository.getReferenceById(id);
	}
	
	public void actualizar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void eliminar(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
