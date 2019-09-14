package ar.edu.unq.ttip.task_man;



import ar.edu.unq.ttip.task_man.model.Proyecto;
import ar.edu.unq.ttip.task_man.model.Tarea;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Buscador {


    private List<Proyecto> proyectos;
    private List<Tarea> tareas;

    public Buscador(){
        this.proyectos = new ArrayList<Proyecto>();
        this.tareas = new ArrayList<Tarea>();
    }
}
