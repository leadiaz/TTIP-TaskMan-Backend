package ar.edu.unq.ttip.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
public class Tarea {
	@Id	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@Column(name = "USUARIO_DESIGNADO")
//	private Usuario usuarioDesignado;
	
	public Tarea() {}
	public Tarea(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Tarea(String nombre, String descripcion, Usuario user) {
		this.nombre = nombre;
		this.descripcion = descripcion;
//		this.usuarioDesignado=user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
//	public Usuario getUsuarioDesignado() {
//		return usuarioDesignado;
//	}
//	public void setUsuarioDesignado(Usuario usuarioDesignado) {
//		this.usuarioDesignado = usuarioDesignado;
//	}
	
	
}
