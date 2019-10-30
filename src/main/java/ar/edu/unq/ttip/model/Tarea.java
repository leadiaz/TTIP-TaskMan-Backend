package ar.edu.unq.ttip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tarea {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descripcion;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties ("proyecto")
	public Usuario asignado;
	@Enumerated(EnumType.ORDINAL)
	public Estado estado;
	public Tarea() {}
	public Tarea(String titulo, String descripcion) {

		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Estado.CREADA;
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
	public Usuario getAsignado() {
		return asignado;
	}
	public void setAsignado(Usuario asignado) {
		this.asignado = asignado;
		this.estado = Estado.EN_PROCESO;
	}


	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
