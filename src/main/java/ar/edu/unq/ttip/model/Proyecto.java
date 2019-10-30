package ar.edu.unq.ttip.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Proyecto {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("proyecto")
	private Usuario creador;
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnoreProperties("proyecto")
	private List<Usuario> miembros = new ArrayList<Usuario>();
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("asignado")
	private Set<Tarea> tareas = new HashSet<Tarea>();
//	
	
	public Proyecto() {}
	public Proyecto(String nombre, Usuario usuario) {
		this.nombre  = nombre;
		this.creador = usuario;
		this.miembros.add(usuario);
	
	}
	public List<Usuario> getMiembros() {
		return miembros;
	}
	public void setMiembros(List<Usuario> miembros) {
		this.miembros = miembros;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
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
	public void addMiembro(Usuario user) {this.miembros.add(user);}
	public Set<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}
	public void addTarea(Tarea tarea) {this.tareas.add(tarea);}
	public void eliminarTarea(Tarea tarea) {
		this.tareas.remove(tarea);
		
	}
}
