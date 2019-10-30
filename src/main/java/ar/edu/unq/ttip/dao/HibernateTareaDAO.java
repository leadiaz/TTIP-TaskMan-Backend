package ar.edu.unq.ttip.dao;

import java.lang.reflect.GenericDeclaration;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unq.ttip.model.Tarea;
@Repository
public class HibernateTareaDAO extends GenericDAO<Tarea>{
	
	public HibernateTareaDAO() {
		super(Tarea.class);
	}
    public List<Tarea> getAsignadas(long idUsuario) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "from Tarea t where t.asignado.id = :unUsuario ";
            Query<Tarea> query = session.createQuery(hql, Tarea.class);
            query.setParameter("unUsuario", idUsuario);
            session.getTransaction().commit();
            return (List<Tarea>) query.getResultList();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
