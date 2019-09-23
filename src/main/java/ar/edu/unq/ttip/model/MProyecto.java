package ar.edu.unq.ttip.model;

import ar.edu.unq.ttip.entity.Proyecto;

public class MProyecto {

	private Long id;
	private String nombre;
	
	public MProyecto() {
		
	}
	public MProyecto(Proyecto proyecto) {
		this.id = proyecto.getId();
		this.nombre= proyecto.getNombre();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
