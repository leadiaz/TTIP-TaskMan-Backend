package ar.edu.unq.ttip.controller;

import java.util.List;

import ar.edu.unq.ttip.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.ttip.model.Proyecto;
import ar.edu.unq.ttip.model.Usuario;
import ar.edu.unq.ttip.services.ProyectoService;
import ar.edu.unq.ttip.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class ProyectoController {
	@Autowired
	ProyectoService proyectService = new ProyectoService();
	
	@Autowired
	UsuarioService userService= new UsuarioService();

	@Autowired
	TareaService tareaService = new TareaService();
	public ProyectoController() {}
    
    
	@RequestMapping(value = "/proyectos", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<List<Proyecto>> getProyectos() {
		
		List<Proyecto> lproyect = this.proyectService.getAll();
		lproyect.stream().forEach((p)->{
			System.out.println(p.getNombre());
			System.out.println(p.getCreador());
			System.out.println(p.getMiembros());
		});
       	return new ResponseEntity<List<Proyecto>>(lproyect,HttpStatus.OK);
    }


	@RequestMapping(value = "/proyecto/{userId}", method = RequestMethod.POST, consumes = "application/json")	
	public ResponseEntity<Void> nuevoProyecto(@PathVariable("userId") long id,@RequestBody Proyecto proyecto){
		Usuario user = userService.getById(id);
		System.out.println(proyecto.getNombre());
		System.out.println(proyecto.getMiembros());
		System.out.println(user);
		if(user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
		else {
			proyecto.setCreador(user);
			proyecto.addMiembro(user);
			user.agregarProyecto(proyecto);
			long idP=this.proyectService.setProyecto(proyecto);
			this.userService.update(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/proyecto/{id}", method = RequestMethod.PUT, consumes = "application/json")	
	public ResponseEntity<Void> actualizarProyecto(@PathVariable("id") long id,@RequestBody Proyecto proyecto){
		Proyecto proyect = proyectService.getById(id);
		if(proyect == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			proyect.setNombre(proyecto.getNombre());
			proyect.setMiembros(proyecto.getMiembros());
			proyect.setTareas(proyecto.getTareas());
			this.proyectService.updateProyecto(proyect);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

	}
//	@RequestMapping(value = "proyecto/{id}", method = RequestMethod.PUT, consumes = "application/json")
//	public ResponseEntity<Void> agregarMiembro(@PathVariable("id") long id, @RequestBody Proyecto proyecto){
//		Proyecto proyect = proyectService.getById(id);
//
//		if(proyect == null) {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}else {
//			proyect.setNombre(proyecto.getNombre());
//			proyect.setMiembros(proyecto.getMiembros());
//			proyect.setTareas(proyecto.getTareas());
//			this.proyectService.updateProyecto(proyect);
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}
//	}
	
	
	@RequestMapping(value = "/proyecto/{id}", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<Proyecto> getProyecto(@PathVariable("id") long id){
		Proyecto proyect=this.proyectService.getById(id);
		if(proyect == null) {
			return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);

		}
		else {
			return new ResponseEntity<Proyecto>(proyect,HttpStatus.OK);

		}
	}

	@RequestMapping(value = "/proyecto/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<Void> eliminarProyecto(@PathVariable("id") long id){
		Proyecto proyecto = this.proyectService.getById(id);
		if (proyecto == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else{
			proyecto.getTareas().forEach(tarea -> this.tareaService.delete(tarea.getId()));
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}
