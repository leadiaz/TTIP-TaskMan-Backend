package ar.edu.unq.ttip.task_man.DAO;
import ar.edu.unq.ttip.task_man.model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.HibernateException;

import static org.springframework.boot.SpringApplication.run;


@Repository
public class UsuarioDao extends GenericDAO<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @SuppressWarnings("deprecation")
    public Boolean validate(Usuario user){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "from " + "User" +
                    " u " + "where u.email = :unNombre "
                    +   "and u.password = :unaContrasenha";
            Query<Usuario> query = session.createQuery(hql, Usuario.class);
            query.setParameter("unNombre", user.email);
            query.setParameter("unaContrasenha", user.password);
            return !query.list().isEmpty();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

    }

    @SuppressWarnings("deprecation")
    public List<Usuario> searchUsers(String nombreBuscado){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "from " + "User" +
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
            String hql = "from " + "User" +
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