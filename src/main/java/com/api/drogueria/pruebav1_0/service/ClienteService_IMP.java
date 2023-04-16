package com.api.drogueria.pruebav1_0.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;



import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.repository.ClienteRepository;




@Service
public class ClienteService_IMP implements ClienteService{

	@Autowired
	private ClienteRepository CRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> getAll() {
		return (List<Cliente>) CRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente FindbyID(long ID) {
		
		return CRepository.findById(ID).orElse(null);
	}

	@Override
	@Transactional
	public Cliente GuardarCliente(Cliente Ncliente) {
		
		return CRepository.save(Ncliente);
	}

	@Override
	public void BorrarCliente(Cliente DCliente) {
		
		CRepository.delete(DCliente);;
	}
	
	
}
