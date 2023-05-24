package com.api.drogueria.pruebav1_0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.drogueria.pruebav1_0.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Long>{

	@Query("select p from Producto p where p.Nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	@Query("select p from Producto p where p.Nombre ilike %?1%")
	public List<Producto> findByNombreContainingIgnoreCase(String term);
	
	
}
