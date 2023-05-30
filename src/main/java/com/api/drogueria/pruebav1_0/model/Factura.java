package com.api.drogueria.pruebav1_0.model;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Facturas")
public class Factura implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	@Column(name="tipo_entrega")
	private String Tipo_entrega;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	


	/* ================= RELACIONES ==================== */
	@JsonIgnoreProperties(value={"facturas","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="cliente_id")
	 private Cliente Cliente;
	 
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="factura_id")
	private List<Item_Factura> items;
	 /* ================= GET y SET===================== */
	
	
	
	public Factura()
	{
		this.items=new ArrayList<>();
	}
	
	
	public List<Item_Factura> getItems() {
		return items;
	}

	public void setItems(List<Item_Factura> items) {
		this.items = items;
	}

	@PrePersist
	public void prePersist() {
		this.create_at = new Date();
	}
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getTipo_entrega() {
		return Tipo_entrega;
	}

	public void setTipo_entrega(String tipo_entrega) {
		Tipo_entrega = tipo_entrega;
	}
	
	
	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	private static final long serialVersionUID = 1L;
	
}
