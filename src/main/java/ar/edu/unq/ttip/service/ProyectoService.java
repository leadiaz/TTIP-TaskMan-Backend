package ar.edu.unq.ttip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unq.ttip.converter.Convertidor;
import ar.edu.unq.ttip.entity.Proyecto;
import ar.edu.unq.ttip.model.MProyecto;
import ar.edu.unq.ttip.repository.ProyectoRep;

@Service("servicio")
public class ProyectoService {
	@Autowired //inyectar
	@Qualifier("repositorio")
	private ProyectoRep repositorio;
	
	@Autowired //inyectar
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean crear(Proyecto proyecto) {
		try {
			repositorio.save(proyecto);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(Proyecto proyecto) {
		try {
			repositorio.save(proyecto);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean borrar(String nombre, Long id) {
		try {
			Proyecto proyecto = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(proyecto);
			return true;
		}
		catch (Exception e) {
			return false;
		}
 	}
	public List<MProyecto> obtener()
	{
		return convertidor.convertirLista(repositorio.findAll());
	}
}
