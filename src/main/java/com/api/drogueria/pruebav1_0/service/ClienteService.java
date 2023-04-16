package com.api.drogueria.pruebav1_0.service;

import java.util.List;


import com.api.drogueria.pruebav1_0.model.Cliente;

public interface ClienteService {

	public List<Cliente> getAll();
	
	public Cliente FindbyID(long ID);
	
	public Cliente GuardarCliente(Cliente Ncliente);  //sirve tanto para nuevos clientes como para modificar
	
	public void BorrarCliente(Cliente DCliente);
}
