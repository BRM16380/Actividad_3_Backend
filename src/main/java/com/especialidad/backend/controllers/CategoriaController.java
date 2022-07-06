package com.especialidad.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.especialidad.backend.model.Categoria;
import com.especialidad.backend.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("")
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		categoriaService.guardar(categoria);
		return categoria;
	}
	
	@GetMapping("")
	public List<Categoria> obtenerCategorias(){
		return categoriaService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Categoria obtenerCategoria(@PathVariable("id") Integer id) {
		return categoriaService.obtenerCategoria(id);
	}
	
	@PutMapping("/{id}")
	public void actualizarCategoria(@RequestBody Categoria categoria) {
		categoriaService.actualizar(categoria);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		categoriaService.eliminar(id);
	}
}
