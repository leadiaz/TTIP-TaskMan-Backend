package ar.edu.unq.ttip.task_man;

import java.util.ArrayList;
import java.util.List;

public class Buscador {


    private List<Proyecto> proyectos;
    private List<Tarea> tareas;

    public Buscador(){
        this.proyectos = new ArrayList<Proyecto>();
        this.tareas = new ArrayList<Tarea>();
    }
}
