package com.api.drogueria.pruebav1_0.model;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID_producto;
	
	@NotEmpty
	@Column(nullable=false,name="Nombre")
	private String Nombre;
	
	private Integer Precio;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;

	/* ================= RELACIONES ==================== */
	 
	
	 
	/* ================= GET y SET===================== */
	
	
	@PrePersist
	public void prePersist() {
		this.create_at = new Date();
	}
	
	
	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public Long getID_producto() {
		return ID_producto;
	}

	public void setID_producto(Long iD_producto) {
		ID_producto = iD_producto;
	}

	public String getNombre_producto() {
		return Nombre;
	}

	public void setNombre_producto(String nombre_producto) {
		Nombre = nombre_producto;
	}


	public Integer getPrecio() {
		return Precio;
	}


	public void setPrecio(Integer precio) {
		Precio = precio;
	}


	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
