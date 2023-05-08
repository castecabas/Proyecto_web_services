package com.api.drogueria.pruebav1_0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.api.drogueria.pruebav1_0.model.Cliente;
import com.api.drogueria.pruebav1_0.model.Region;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{

	@Query("from Region")
	public List<Region> findAllRegiones();
}
