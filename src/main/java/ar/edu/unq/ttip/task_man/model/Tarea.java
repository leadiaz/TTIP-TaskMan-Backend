package ar.edu.unq.ttip.task_man.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    private final String name;
    private final String description;

    public Tarea(String name, String description){
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
