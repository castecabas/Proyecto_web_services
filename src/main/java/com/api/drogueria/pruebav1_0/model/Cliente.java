package com.api.drogueria.pruebav1_0.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.NoProviderFoundException;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long ID;
	  
	 @NotEmpty(message="No debe estar vacia el campo del nombre")
	 @Size(min=3,max=30,message="debe ser el tamaño entre 3 y 30 letras")
	 @Column(nullable=false,name="nombre")
	 private String nombre;
	 
	 @NotEmpty(message="No debe estar vacia el campo del apellido")
	 @Column(nullable=false,name="apellido")
	 private String apellido;
	 
	 @Email(message="debe ser bien estructurada el email")
	 @Column(nullable=false,name="correo")
	 private String correo;
	 
	 @Column(name="create_at")
	 private Date Date_creacion;
	 
	 
	 /* ================= RELACIONES ==================== */
	 
	 @JsonIgnoreProperties({"cliente","hibernateLazyInitializer","handler"})
	 @NotNull(message="la region no puede ser vacia")
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="region_id")
	 private Region region;
	 
	 
	 @JsonIgnoreProperties(value= {"cliente","hibernateLazyInitializer","handler"},allowSetters=true)
	 @OneToMany(mappedBy="Cliente",cascade=CascadeType.ALL,orphanRemoval=true)
	 private List<Factura> Facturas;
	 
	 
	 /* ================= GET y SET===================== */
	 
	 
	 
	public Long getID() {
		return ID;
	}



	public List<Factura> getFacturas() {
		return Facturas;
	}



	public void setFacturas(List<Factura> facturas) {
		Facturas = facturas;
	}



	public Region getRegion() {
		return region;
	}



	public void setRegion(Region region) {
		this.region = region;
	}



	public void setID(Long iD) {
		ID = iD;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public Date getDate_creacion() {
		return Date_creacion;
	}



	public void setDate_creacion(Date date_creacion) {
		Date_creacion = date_creacion;
	}


	private static final long serialVersionUID = 1L;
}
