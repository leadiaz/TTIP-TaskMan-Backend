package ar.edu.unq.ttip.task_man.service;

import ar.edu.unq.ttip.task_man.DAO.UsuarioDao;
import ar.edu.unq.ttip.task_man.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ServiceUsuario {

    @Autowired
    private UsuarioDao userDAO;
    public ServiceUsuario(){
        userDAO = new UsuarioDao();
    }

    @Transactional
    public List<Usuario> getAll(){
        return userDAO.getAll();
    }

    @Transactional
    public void setUser(Usuario user) {
        userDAO.save(user);
    }
    @Transactional
    public Usuario getById(Long id) {
        return userDAO.getById(id);
    }

    @Transactional
    public Usuario getByUsername(String username) {
        return userDAO.getByUsername(username);
    }


    @Transactional
    public void updateUser(Usuario user) {
        userDAO.update(user);
    }

    @Transactional
    public Boolean validate(Usuario user){
        return userDAO.validate(user);
    }

    @Transactional
    public List<Usuario> search(String nombre){
        return userDAO.searchUsers(nombre);
    }
}
