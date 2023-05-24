package com.api.drogueria.pruebav1_0.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.drogueria.pruebav1_0.model.Factura;
import com.api.drogueria.pruebav1_0.model.Producto;
import com.api.drogueria.pruebav1_0.repository.ProductoRepository;
import com.api.drogueria.pruebav1_0.service.ClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/facturas/{ID}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable Long ID)
	{
		return clienteService.findFacturaById(ID);
	}
	
	@GetMapping("/facturas")
	@ResponseStatus(HttpStatus.OK)
	public List<Factura> index()
	{
		return clienteService.findAllFacturas();
	}
	
	@DeleteMapping("/facturas/{ID}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long ID)
	{
		clienteService.deleteFacturaByID(ID);
	}
	
	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura Crear(@RequestBody Factura factura)
	{
		return clienteService.saveFactura(factura);
	}
	
	@GetMapping("/facturas/filtrar-productos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> FiltrarProductos(@PathVariable String term)
	{
		return clienteService.FiltrarProducto(term);
	}
	
	@GetMapping("/facturas/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> Producto()
	{
		return clienteService.findAllProducto();
	}
}
