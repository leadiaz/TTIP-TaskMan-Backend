package ar.edu.unq.ttip.model;

import ar.edu.unq.ttip.entity.Tarea;

public class MTarea {
	private Long id;
	private String nombre;
	private String descripcion;
	private MUsuario usuarioDesignado;
	
	public MTarea() {}
	public MTarea(Tarea tarea) {
		this.nombre=tarea.getNombre();
		this.descripcion=tarea.getDescripcion();
		this.id=tarea.getId();

	}
	public MTarea(String nombre, String descripcion, MUsuario usuarioDesignado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioDesignado = usuarioDesignado;
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
	public MUsuario getUsuarioDesignado() {
		return usuarioDesignado;
	}
	public void setUsuarioDesignado(MUsuario usuarioDesignado) {
		this.usuarioDesignado = usuarioDesignado;
	}
	
	
}
