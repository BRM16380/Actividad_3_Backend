package com.especialidad.backend.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.especialidad.backend.model.Producto;

@FeignClient(name= "productos", url="http://localhost:8080/productos")
public interface VentasFeignClient {

	@GetMapping()
	List<Producto> obtenerVentas();
}
