package ar.edu.unq.ttip.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ar.edu.unq.ttip.repository.ProyectoRep;


@Table(name="proyecto")
@Entity
public class Proyecto implements ProyectoRep  {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	public Proyecto() {}
	

	public Proyecto(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Proyecto> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Proyecto> findAllById(Iterable<Serializable> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Proyecto> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteInBatch(Iterable<Proyecto> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Proyecto getOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Proyecto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Proyecto> findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Proyecto entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Proyecto> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Proyecto> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Proyecto> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Proyecto> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Proyecto findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Proyecto findByNombreAndId(String nombre, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
