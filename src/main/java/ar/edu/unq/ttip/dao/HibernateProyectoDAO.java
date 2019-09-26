package ar.edu.unq.ttip.dao;

import org.springframework.stereotype.Repository;

import ar.edu.unq.ttip.model.Proyecto;

@Repository
public class HibernateProyectoDAO extends GenericDAO<Proyecto> {
	public HibernateProyectoDAO() {
		super(Proyecto.class);
	}
}
