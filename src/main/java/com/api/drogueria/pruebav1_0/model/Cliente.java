package com.api.drogueria.pruebav1_0.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
	 @Column(nullable=false)
	 private String nombre;
	 
	 @NotEmpty(message="No debe estar vacia el campo del apellido")
	 @Column(nullable=false)
	 private String apellido;
	 
	 @Email(message="debe ser bien estructurada el email")
	 @Column(nullable=false,unique=true,name="EMAIL")
	 private String correo;
	 
	 @Column(name="create_at")
	 private Date Date_creacion;
	 
	 
	 
	public Long getID() {
		return ID;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;
}
