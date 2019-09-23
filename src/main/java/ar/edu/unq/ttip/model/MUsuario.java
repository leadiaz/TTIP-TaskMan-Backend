package ar.edu.unq.ttip.model;

import java.util.Set;

import ar.edu.unq.ttip.entity.Usuario;

public class MUsuario {
	
	private Long id;
	private String usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
//	private Set<Long> proyectos;
	
	public MUsuario() {}
	public MUsuario(Usuario usuario) {
		this.id = usuario.getId();
		this.usuario = usuario.getUsuario();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
//		this.proyectos = usuario.getProyectos();
	}
	public MUsuario(Long id, String usuario, String nombre, String apellido, String email, String password,
			Set<Long> proyectos) {
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
//		this.proyectos = proyectos;
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
//	public Set<Long> getProyectos() {
//		return proyectos;
//	}
//	public void setProyectos(Set<Long> proyectos) {
//		this.proyectos = proyectos;
//	}
}
