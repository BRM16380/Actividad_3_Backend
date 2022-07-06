package com.especialidad.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.especialidad.backend.feign.VentasFeignClient;
import com.especialidad.backend.model.Producto;

@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private VentasFeignClient ventasClient;
	
	@GetMapping("")
	public List<Producto> obtenerVentas(){
		return ventasClient.obtenerVentas();
	}
}
