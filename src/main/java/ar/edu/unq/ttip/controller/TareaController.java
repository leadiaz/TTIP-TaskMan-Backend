package ar.edu.unq.ttip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.ttip.model.Proyecto;
import ar.edu.unq.ttip.model.Tarea;
import ar.edu.unq.ttip.services.ProyectoService;
import ar.edu.unq.ttip.services.TareaService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TareaController {

	@Autowired
	TareaService service = new TareaService();
	@Autowired
	ProyectoService proyectoService = new ProyectoService();
	
	 @RequestMapping(value = "/tareas", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Tarea>> getTareas() {
	         List<Tarea> tareas = this.service.getAll();
	        if (tareas == null) {
	            return new ResponseEntity<List<Tarea>>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);
	    }

	 @RequestMapping(value = "/tarea/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Tarea> getTarea(@PathVariable("id") Long id) {
	         Tarea tarea= this.service.getById(id);
	        if (tarea == null) {
	            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
	    }
	 @RequestMapping(value = "/tareas/{idUsuario}", method = RequestMethod.GET)
	 	public ResponseEntity<List<Tarea>> getAllUsuario(@PathVariable ("idUsuario") Long idUsuario){
	 		List<Tarea> tareas = this.service.getAsignadas(idUsuario);
	 		if(tareas.isEmpty()){
	 			return new ResponseEntity<List<Tarea>>(HttpStatus.NOT_FOUND);
			}
	 		return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);
	 	}
	 @RequestMapping(value = "/tarea/{idProyecto}", method = RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Tarea> create(@RequestBody Tarea input, @PathVariable ("idProyecto") long idProyecto) throws Exception{
		 	Proyecto proyecto=this.proyectoService.getById(idProyecto);
		 	if(proyecto == null) {
		 		return new ResponseEntity<Tarea>(HttpStatus.NOT_ACCEPTABLE);
		 	}
		 	else {
				 Tarea tarea = new Tarea(input.getTitulo(),input.getDescripcion());
		         this.service.save(tarea);
		         
		         proyecto.addTarea(tarea);
		         this.proyectoService.updateProyecto(proyecto);
		         return new ResponseEntity<Tarea>(tarea,HttpStatus.OK);

		 	}
	    }
	    @RequestMapping(value = "/tarea/{id}/{idProyecto}", method = RequestMethod.DELETE, consumes = "application/json")
	    public ResponseEntity<Tarea> deleteTask(@PathVariable("id") long id,@PathVariable("idProyecto") long idProy) {
	        System.out.println("Fetching & Deleting Issue with id " + id);
	 
	        Tarea task = service.getById(id);
	        Proyecto proyecto = proyectoService.getById(idProy);
	        if (task == null || proyecto == null) {
	            System.out.println("Unable to delete. Task with id " + id + " not found");
	            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
	        }
	     
    		proyecto.eliminarTarea(task);
			proyectoService.updateProyecto(proyecto);
            this.service.delete(task.getId());

	        return new ResponseEntity<Tarea>(HttpStatus.OK);
	    }
	    
	    @RequestMapping(value = "/tarea/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Tarea> updateTask(@PathVariable("id") long id, @RequestBody Tarea task ){
	        Tarea tarea = service.getById(id);
	         
	        if (tarea==null) {
	            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
	        }
	        tarea.setTitulo(task.getTitulo());
	        tarea.setAsignado(task.getAsignado());
	        tarea.setDescripcion(task.getDescripcion());

	        service.update(tarea);
	        return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
	    }


}
