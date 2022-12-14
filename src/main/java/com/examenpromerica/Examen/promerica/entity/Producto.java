package com.examenpromerica.Examen.promerica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "productos")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private float precio;
	
	@Column(name = "estado")
	private String estado="A";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Producto() {
		
	}
	public Producto(Integer id,String nombres,String descripcion,float precio,String estado) {
		   this.id=id;
		   this.nombres=nombres;
		   this.descripcion=descripcion;
		   this.precio=precio;
		   this.estado=estado;
		}

}
