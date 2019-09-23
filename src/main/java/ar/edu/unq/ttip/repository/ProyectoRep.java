package ar.edu.unq.ttip.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.ttip.entity.Proyecto;

@Repository("repositorio")
public interface ProyectoRep extends JpaRepository<Proyecto, Serializable> {
	public abstract Proyecto findByNombre(String nombre);
	public abstract Proyecto findByNombreAndId(String nombre, Long id);
}
