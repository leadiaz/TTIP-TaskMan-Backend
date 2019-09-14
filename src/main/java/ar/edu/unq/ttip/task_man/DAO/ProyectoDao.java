package ar.edu.unq.ttip.task_man.DAO;

import ar.edu.unq.ttip.task_man.model.Proyecto;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectoDao extends GenericDAO<Proyecto> {
    public ProyectoDao(){
        super(Proyecto.class);
    }

}
