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
import java.time.LocalDate;
import java.time.LocalTime;

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
	public LocalDate fecha_creacion;
	public LocalDate fecha_estimada;



	@Enumerated(EnumType.ORDINAL)
	public Prioridad prioridad;

	public Tarea() {}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Tarea(String titulo, String descripcion) {

		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Estado.CREADA;
		this.fecha_creacion = LocalDate.now();
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

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public LocalDate getFecha_estimada() {
		return fecha_estimada;
	}

	public void setFecha_estimada(LocalDate fecha_estimada) {
		this.fecha_estimada = fecha_estimada;
	}
}
