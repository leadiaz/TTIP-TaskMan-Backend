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

import ar.edu.unq.ttip.model.Usuario;
import ar.edu.unq.ttip.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {
	@Autowired
	UsuarioService userService = new UsuarioService();
	
	public UsuarioController() {}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<List<Usuario>> getUsers() {
		return new ResponseEntity<List<Usuario>>(this.userService.getAll(),HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")   
	public ResponseEntity<Void> createUser(@RequestBody Usuario user) {

			
			this.userService.setUser(user);
//			try {			
//				MimeMessage msg = sender.createMimeMessage();
//		         MimeMessageHelper msgHelper = new MimeMessageHelper(msg,true); 	         
//		         msgHelper.setTo(user.email);
//		         msgHelper.setText("Bienvenido/a a Vopros! Empieza ya mismo creando un proyecto");
//		         msgHelper.setSubject("Bienvenido/a!");
//		         sender.send(msg);}
//			catch(Exception e) {e.printStackTrace();}

			return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/user/search", method = RequestMethod.POST, produces = "application/json")   
	public ResponseEntity<List<Usuario>> searchUser(@RequestBody String user) {

			List<Usuario> results = this.userService.search(user);
			System.out.println(results);
			
			return new ResponseEntity<List<Usuario>>(results,HttpStatus.OK);

	}
	
	
	
	@RequestMapping(value = "/user/search/{val}", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<List<Usuario>> searchUserName(@PathVariable("val") String user) {

			List<Usuario> results = this.userService.search(user);
			System.out.println(results);
			
			return new ResponseEntity<List<Usuario>>(results,HttpStatus.OK);

	}
	
	
	
	@RequestMapping(value = "/user/byUsername/{username}", method = RequestMethod.GET, produces = "application/json")   
	public ResponseEntity<Usuario> getUserByUsername(@PathVariable("username") String user) {

			Usuario result = this.userService.getByUsername(user);
//			System.out.println(result.proyectos);
			if(result == null) {return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);};
			return new ResponseEntity<Usuario>(result,HttpStatus.OK);

			
			

	}
	
	
}
