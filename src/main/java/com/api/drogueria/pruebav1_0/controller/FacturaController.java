package com.api.drogueria.pruebav1_0.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.model.Factura;
import com.api.drogueria.pruebav1_0.model.Producto;
import com.api.drogueria.pruebav1_0.repository.ProductoRepository;
import com.api.drogueria.pruebav1_0.service.ClienteService;

import jakarta.validation.Valid;

//@CrossOrigin(origins= {"http://localhost:4200"})


@RestController
@CrossOrigin(origins= {"https://mi-api-frontend-web-services.web.app"})
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
	
	@PostMapping("/facturas/productos")
	public ResponseEntity<?> CrearProducto(@Valid @RequestBody Producto producto, BindingResult result)  //responseentity podemos incluir respuesta de Status ("error 200-300-400...etc") 
	{																							//valid es para cumplir con las anotaciones que colocamos en la tabla (notempty ,email ,size )
		Producto Productonew = null;

		Map<String, Object> response = new HashMap<>(); //construye respuesta a retornar

		if (result.hasErrors()) {												//si posee errores
			List<String> errors = result.getFieldErrors().stream()				//guardar lista de los errores
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		//si no hay errores, entonces:
		try 
		{
			Productonew = this.clienteService.saveProducto(producto);
		} 
		//puede ser sensible en el proceso de guardado,entonces si pasa algo:
		catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar un INSERT en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//mensaje de si el INSERT se realizo con exito
		response.put("mensaje", "El producto ha sido creado con éxito!");
		response.put("producto", Productonew);

		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
}
