package com.api.drogueria.pruebav1_0.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	/* CONTINUAR*/
	
	@GetMapping("/Lista-clientes")
	public List<Cliente> getAll()
	{
		return this.clienteService.getAll();
	}
	
	@GetMapping("/Lista-clientes/{ID}")
	public Cliente buscarporID(@PathVariable long ID)
	{
		return clienteService.FindbyID(ID);
		
	}
	
	@PostMapping("/Lista-clientes/actualizar")
	public ResponseEntity<?> Crear(@Valid @RequestBody Cliente cliente, BindingResult result)  //responseentity podemos incluir respuesta de Status ("error 200-300-400...etc") 
	{																							//valid es para cumplir con las anotaciones que colocamos en la tabla (notempty ,email ,size )
		Cliente clienteNew = null;

		Map<String, Object> response = new HashMap<>(); //construye respuesta a retornar

		if (result.hasErrors()) {												//si posee errores
			List<String> errors = result.getFieldErrors().stream()				//guardar lista de los errores
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteNew = this.clienteService.GuardarCliente(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);

		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/Lista-clientes/{ID}")	
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente,BindingResult result,@PathVariable  Long id){
		
		Cliente currentCliente=this.clienteService.FindbyID(id);
		
		Cliente updateCliente=null;
		
        Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		if(currentCliente==null){
			response.put("mensaje", "Error: no se puede editar, el cliente ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		try{
			currentCliente.setNombre(cliente.getNombre());
			currentCliente.setApellido(cliente.getApellido());
			currentCliente.setCorreo(cliente.getCorreo());
			updateCliente=this.clienteService.GuardarCliente(currentCliente);
			
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje","El cliente ha sido actulizado con éxito!");
		response.put("cliente", updateCliente);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response=new HashMap<>();		
		try {
			
			Cliente cliente=this.clienteService.FindbyID(id);
		    this.clienteService.BorrarCliente(cliente);
		
		}catch(DataAccessException e){
			 response.put("mensaje", "Error al eliminar el cliente en la base de datos");
			 response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		 response.put("mensaje", "El cliente eliminado con éxito");		 
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
}
