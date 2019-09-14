package ar.edu.unq.ttip.task_man.model;

import ar.edu.unq.ttip.task_man.model.Rol;
import ar.edu.unq.ttip.task_man.model.Tarea;
import ar.edu.unq.ttip.task_man.model.Usuario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Usuario creator;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
    private Set<Tarea> tareas;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<Rol> roles; //cambiar por un tipo rol
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "miembro", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios;

    public Proyecto(Usuario creator, String name){
        this.creator = creator;
        this.name = name;
        this.roles = new HashSet<Rol>();
        this.usuarios = new HashSet<Usuario>();
        this.tareas = new HashSet<Tarea>();
     }

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public Usuario getCreator() {
        return creator;
    }
    public Set<Rol> getRoles(){
        return roles;
    }

    public Set<Tarea> getTarea(Tarea tarea) {
         return tareas;
     }
}
