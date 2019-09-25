package ar.edu.unq.ttip.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.ttip.model.Usuario;
@Repository
public class HibernateUsuarioDAO extends GenericDAO<Usuario> {
	public HibernateUsuarioDAO() {
		super(Usuario.class);
	}
	@SuppressWarnings("deprecation")
	public List<Usuario> searchUsers(String nombreBuscado){
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "from " + "Usuario" + 
						" u " + "where u.usuario like :unNombre";
			Query<Usuario> query = session.createQuery(hql, Usuario.class);
			query.setParameter("unNombre", "%"+nombreBuscado+"%");
			return query.list();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public Usuario getByUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "from " + "Usuario" + 
						" u " + "where u.usuario = :unNombre";
			Query<Usuario> query = session.createQuery(hql, Usuario.class);
			query.setParameter("unNombre", username);
			return query.getSingleResult();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

}
