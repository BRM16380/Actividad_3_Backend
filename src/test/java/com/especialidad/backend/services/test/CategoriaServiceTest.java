package com.especialidad.backend.services.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.especialidad.backend.model.Categoria;
import com.especialidad.backend.repository.CategoriaRepository;
import com.especialidad.backend.services.CategoriaService;



public class CategoriaServiceTest {
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private CategoriaService categoriaService;
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private Categoria categoria1;
	private Categoria categoria2;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Electrodomesticos");
		
		categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Sala de estar");
		
		categorias.add(categoria1);
		categorias.add(categoria2);
	}
	
	@Test
	void obtenerTodos() {
		when(categoriaRepository.findAll()).thenReturn(categorias);
		assertNotNull(categoriaService.obtenerTodos());
	}
	
	@Test
	void obtenerProducto() {
		when(categoriaRepository.getReferenceById(2)).thenReturn(categoria2);
		assertNotNull(categoriaService.obtenerCategoria(2));
	}
	
	@Test
	void guardar() {		
		when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria1);
		assertNotNull(categoriaService.guardar(categoria1));
	}
	
	@Test
	void actualizar() {
		when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria1);
		assertNotNull(categoriaService.actualizar(categoria1));
	}
	
	@Test
	void eliminar() {
		categoriaService.eliminar(categoria1.getId());
		verify(categoriaRepository, times(1)).deleteById(categoria1.getId());
	}
}
