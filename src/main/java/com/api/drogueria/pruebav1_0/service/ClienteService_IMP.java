package com.api.drogueria.pruebav1_0.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;



import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.model.Factura;
import com.api.drogueria.pruebav1_0.model.Producto;
import com.api.drogueria.pruebav1_0.model.Region;
import com.api.drogueria.pruebav1_0.repository.ClienteRepository;
import com.api.drogueria.pruebav1_0.repository.FacturaRepository;
import com.api.drogueria.pruebav1_0.repository.ProductoRepository;


@Service
public class ClienteService_IMP implements ClienteService{

	@Autowired
	private ClienteRepository CRepository;
	
	@Autowired
	private FacturaRepository FRepository;
	
	@Autowired
	private ProductoRepository PRepository;
	
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
		
		CRepository.delete(DCliente);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAllProducto() {
		return (List<Producto>) PRepository.findAll();
	}

	

	@Override
	@Transactional(readOnly=true)
	public List<Factura> findAllFacturas() {
		return (List<Factura>) FRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findFacturaById(Long ID) {
		return FRepository.findById(ID).orElse(null);
	}

	@Override
	public Factura saveFactura(Factura factura) {
	
		return FRepository.save(factura);
	}

	@Override
	public void deleteFacturaByID(Long ID) {
		
		FRepository.deleteById(ID);
	}

	@Override
	public List<Region> findAllRegiones() {
		return CRepository.findAllRegiones();
	}

	@Override
	public List<Producto> FiltrarProducto(String term) {
	
		return PRepository.findByNombreContainingIgnoreCase(term);
	}

	

	
	
	
	
}
