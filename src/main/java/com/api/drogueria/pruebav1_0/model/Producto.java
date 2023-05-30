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
	private Long ID;
	
	@NotEmpty
	@Column(nullable=false,name="nombre")
	private String Nombre;
	
	@Column(name="precio")
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


	
	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
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
