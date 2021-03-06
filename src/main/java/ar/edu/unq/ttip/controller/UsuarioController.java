package ar.edu.unq.ttip.controller;

import java.util.List;

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
import ar.edu.unq.ttip.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class UsuarioController {
	@Autowired
	UsuarioService userService = new UsuarioService();
	
	public UsuarioController() {}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<List<Usuario>> getUsers() {
		return new ResponseEntity<List<Usuario>>(this.userService.getAll(),HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST, produces = "application/json")   
	public ResponseEntity<Void> createUser(@RequestBody Usuario user) {

			
			this.userService.setUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> updateUser(@PathVariable("id") long id,@RequestBody Usuario usuario){
	    System.out.println(usuario.getNombre());
		Usuario user= userService.getById(id);
		System.out.println("peticion de put, " + user);
		if(user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
		    System.out.println(usuario.getUsuario());
            System.out.println(usuario.getProyecto());
			user.setUsuario(usuario.getUsuario());
			user.setNombre(usuario.getNombre());
			user.setApellido(usuario.getApellido());
			user.setEmail(usuario.getEmail());
			user.setPassword(usuario.getPassword());
			user.setProyecto(usuario.getProyecto());
			this.userService.update(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/usuario/buscar", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<List<Usuario>> searchUser(@RequestBody String user) {

			List<Usuario> results = this.userService.search(user);
			System.out.println(results);
			
			return new ResponseEntity<List<Usuario>>(results,HttpStatus.OK);

	}
	
	
	
//	@RequestMapping(value = "/usuario/buscar/{val}", method = RequestMethod.GET, produces = "application/json")   
//	public ResponseEntity<List<Usuario>> searchUserName(@PathVariable("val") String user) {
//
//			List<Usuario> results = this.userService.search(user);
//			System.out.println(results);
//			
//			return new ResponseEntity<List<Usuario>>(results,HttpStatus.OK);
//
//	}
	
	
	
//	@RequestMapping(value = "/usuario/buscar/{username}", method = RequestMethod.GET, produces = "application/json")
	@RequestMapping(value = "/usuario/buscar/{username}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Usuario> getUserByUsername(@PathVariable("username") String user) {

			Usuario result = this.userService.getByUsername(user);
			if(result == null) {return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);};
			return new ResponseEntity<Usuario>(result,HttpStatus.OK);

	}
	
	
}
