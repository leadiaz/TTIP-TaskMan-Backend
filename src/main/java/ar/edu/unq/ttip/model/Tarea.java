package ar.edu.unq.ttip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descripcion;
	public Tarea() {}
	public Tarea(String titulo, String descripcion) {

		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
