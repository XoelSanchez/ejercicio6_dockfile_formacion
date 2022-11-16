package com.curso.model;

public class Formacion {
	
	private String curso;
	private int asignaturas;
	private Double precio;
	
	public Formacion(String curso, int asignaturas, Double precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}
	
	public Formacion() {
		super();
	}
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public int getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
