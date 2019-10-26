package ar.edu.unq.ttip.model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	public Long id;
	@Column(unique=true)
	private String usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("miembros")
	private Set<Proyecto> proyectos = new HashSet<Proyecto>();
	
	public Usuario() {}
	
	public Usuario(String unUsuario,String unNombre, 
					String unApellido, String unEmail,
					String unaContrasenha){
		this.usuario = unUsuario;
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.email = unEmail;
		this.password = unaContrasenha;

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

	public Set<Proyecto> getProyecto() {
		return proyectos;
	}

	public void setProyecto(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);	
	}

    public void actualizarProyectos(Proyecto proyecto) {
	    Optional<Proyecto> proyectoStream = this.proyectos.stream().filter(p ->p.getId() == proyecto.getId()).findFirst();
        System.out.println("actualizando usuario: " + this.usuario);
        System.out.println(proyectoStream.isPresent());
	    if (!proyectoStream.isPresent()){
	        System.out.println("no existia proyecto");
            this.proyectos.add(proyecto);
        }else{
	        proyectoStream.get().setMiembros(proyecto.getMiembros());
            proyectoStream.get().setTareas(proyecto.getTareas());

        }
    }
}
