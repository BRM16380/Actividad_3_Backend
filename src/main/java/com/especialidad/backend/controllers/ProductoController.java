package com.especialidad.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.especialidad.backend.model.Producto;
import com.especialidad.backend.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("")
	public Producto guardarProducto(@RequestBody Producto producto) {
		productoService.guardar(producto);
		return producto;
	}
	
	@GetMapping("")
	public List<Producto> obtenerProductos(){
		return productoService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Producto obtenerProducto(@PathVariable("id") Integer id) {
		return productoService.obtenerProducto(id);
	}
	
	@PutMapping("/{id}")
	public void actualizarProducto(@RequestBody Producto producto) {
		productoService.actualizar(producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		productoService.eliminar(id);
	}
}
