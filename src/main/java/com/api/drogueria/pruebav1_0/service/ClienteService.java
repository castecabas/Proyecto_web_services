package com.api.drogueria.pruebav1_0.service;

import java.util.List;


import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.model.Factura;
import com.api.drogueria.pruebav1_0.model.Producto;
import com.api.drogueria.pruebav1_0.model.Region;

public interface ClienteService {

	public List<Cliente> getAll();
	public Cliente FindbyID(long ID);
	public Cliente GuardarCliente(Cliente Ncliente);  //sirve tanto para nuevos clientes como para modificar
	public void BorrarCliente(Cliente DCliente);
	
	
	public List<Region> findAllRegiones();
	
	
	public List<Producto> findAllProducto();
	public List<Producto> FiltrarProducto(String term);
	
	public List<Factura> findAllFacturas();
	public Factura findFacturaById(Long ID);
	public Factura saveFactura(Factura factura);
	public void deleteFacturaByID(Long ID);


}
