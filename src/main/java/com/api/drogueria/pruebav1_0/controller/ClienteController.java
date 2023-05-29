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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.api.drogueria.pruebav1_0.model.Factura;
import com.api.drogueria.pruebav1_0.model.Producto;
import com.api.drogueria.pruebav1_0.model.Region;
import com.api.drogueria.pruebav1_0.service.ClienteService;
import com.api.drogueria.pruebav1_0.service.ClienteService_IMP;

import jakarta.validation.Valid;

//@CrossOrigin(origins= {"http://localhost:4200"})

@CrossOrigin(origins= {"https://mi-primera-api-bq2r.onrender.com"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	 
	// CONTROLADORES URL
	
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
	
	//CREAR
	@PostMapping("/Lista-clientes")
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
		
		//si no hay errores, entonces:
		try 
		{
			clienteNew = this.clienteService.GuardarCliente(cliente);
		} 
		//puede ser sensible en el proceso de guardado,entonces si pasa algo:
		catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar un INSERT en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//mensaje de si el INSERT se realizo con exito
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);

		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	//ACTUALIZAR
	@PutMapping("/Lista-clientes/actualizar/{ID}")	
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente,BindingResult result,@PathVariable Long ID){
		
		Cliente currentCliente=this.clienteService.FindbyID(ID);
		
		Cliente updateCliente=null;
		
        Map<String, Object> response=new HashMap<>();
		
        // SI TENIA ERRORES
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		// si el cliente en la lista NO EXISTE
		if(currentCliente==null){
			response.put("mensaje", "Error: no se puede editar, el cliente ID: ".concat(ID.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		
		// SI FUE CON EXITO
		try{
			currentCliente.setNombre(cliente.getNombre());
			currentCliente.setApellido(cliente.getApellido());
			currentCliente.setCorreo(cliente.getCorreo());
			currentCliente.setDate_creacion(cliente.getDate_creacion());
			updateCliente=this.clienteService.GuardarCliente(currentCliente);
			
		}
		// SI pasa algo mientras se actualiza
		catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//mensaje final
		response.put("mensaje","El cliente ha sido modificado con éxito!");
		response.put("cliente", updateCliente);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}
	
	// ELIMINAR
	@DeleteMapping("/Lista-clientes/{id}")
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
	
	@GetMapping("/Lista-clientes/regiones")
	public List<Region> listarRegiones()
	{
		return clienteService.findAllRegiones();
	}
}
