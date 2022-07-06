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

import com.especialidad.backend.model.Producto;
import com.especialidad.backend.repository.ProductoRepository;
import com.especialidad.backend.services.ProductoService;

public class ProductoServiceTest {
	
	@Mock
	private ProductoRepository productoRepository;
	
	@InjectMocks
	private ProductoService productoService;
	
	private List<Producto> productos = new ArrayList<Producto>();
	private Producto producto1;
	private Producto producto2;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		producto1 = new Producto();
		producto1.setId(1);
		producto1.setNombre("Estufa");
		producto1.setPrecio(4000);
		
		producto2 = new Producto();
		producto2.setId(2);
		producto2.setNombre("Tostador");
		producto2.setPrecio(1000);
		
		productos.add(producto1);
		productos.add(producto2);
	}
	
	@Test
	void obtenerTodos() {
		when(productoRepository.findAll()).thenReturn(productos);
		assertNotNull(productoService.obtenerTodos());
	}
	
	@Test
	void obtenerProducto() {
		when(productoRepository.getReferenceById(2)).thenReturn(producto2);
		assertNotNull(productoService.obtenerProducto(2));
	}
	
	@Test
	void guardar() {		
		when(productoRepository.save(any(Producto.class))).thenReturn(producto1);
		assertNotNull(productoService.guardar(producto1));
	}
	
	@Test
	void actualizar() {
		when(productoRepository.save(any(Producto.class))).thenReturn(producto1);
		assertNotNull(productoService.actualizar(producto1));
	}
	
	@Test
	void eliminar() {
		productoService.eliminar(producto1.getId());
		verify(productoRepository, times(1)).deleteById(producto1.getId());
	}
}
