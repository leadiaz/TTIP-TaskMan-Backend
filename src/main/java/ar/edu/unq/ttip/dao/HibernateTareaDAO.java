package ar.edu.unq.ttip.dao;

import java.lang.reflect.GenericDeclaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unq.ttip.model.Tarea;
@Repository
public class HibernateTareaDAO extends GenericDAO<Tarea>{
	
	public HibernateTareaDAO() {
		super(Tarea.class);
	}
}
