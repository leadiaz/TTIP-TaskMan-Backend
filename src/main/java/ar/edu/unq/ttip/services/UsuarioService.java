package ar.edu.unq.ttip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.ttip.dao.HibernateUsuarioDAO;
import ar.edu.unq.ttip.model.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private HibernateUsuarioDAO userDAO;
	public UsuarioService(){
		userDAO = new HibernateUsuarioDAO();
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
	public void update(Usuario user) {
		System.out.println("actualizando " + user.getUsuario());
		userDAO.update(user);
	}
	@Transactional
	public List<Usuario> search(String nombre){
		return userDAO.searchUsers(nombre);
	}
}
