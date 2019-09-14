package ar.edu.unq.ttip.task_man.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    public String usuario;
    public String nombre;
    public String apellido;
    public String email;
    public String password;
    @ElementCollection(fetch = FetchType.LAZY, targetClass =Long.class)
    public Set<Proyecto> proyectos;

    public Usuario(){}
    public Usuario(String usuario, String nombre, String apellido, String email, String password){
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password= password;
        this.proyectos = new HashSet<Proyecto>();
    }

    public Long getId() {
        return id;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }
}
