package ar.edu.unq.ttip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.ttip.dao.HibernateTareaDAO;
import ar.edu.unq.ttip.model.Tarea;

@Service("tareaService")
public class TareaService {
	@Autowired
	private HibernateTareaDAO tareaDao;
	
	public TareaService() {
		tareaDao = new HibernateTareaDAO();
	}
	@Transactional
	public void save(Tarea task) {
		tareaDao.save(task);
	}

	@Transactional
	public void update(Tarea task) {
		tareaDao.update(task);
	}

	@Transactional
	public void delete(Long id) {
		tareaDao.delete(getById(id));
	}

	@Transactional
	public Tarea getById(Long id) {
		return tareaDao.getById(id);
	}

	@Transactional
	public List<Tarea> getAll() {
		return tareaDao.getAll();
	}
}
