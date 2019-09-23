package ar.edu.unq.ttip.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
//	@Column
	private Long id;
//	@Column(name="USUARIO", unique=true)
	private String usuario;
//	@Column(name="NOMBRE")
	private String nombre;
//	@Column(name="APELLIDO")
	private String apellido;
//	@Column(name="EMAIL")
	private String email;
//	@Column(name="PASSWORD")
	private String password;
//	@ElementCollection(fetch=FetchType.LAZY,targetClass=Long.class)
//	private Set<Long> proyectos;
	
	public Usuario() {}
	public Usuario(Long id, String usuario, String nombre, String apellido, String email, String password) {
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	public Set<Long> getProyectos() {
//		return proyectos;
//	}
//
//	public void setProyectos(Set<Long> proyectos) {
//		this.proyectos = proyectos;
//	}
//	
	
	

}
