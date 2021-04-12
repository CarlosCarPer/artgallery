package com.carlos.artgallery.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.artgallery.models.entities.Usuario;
import com.carlos.artgallery.models.services.IUsuarioService;

@CrossOrigin(origins= {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = {"Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"})
@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/users")
	public List<Usuario> index(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Usuario user = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();	
		
		try {
			user = userService.findById(id);
		} catch (Exception e) {  // Base de datos inaccesible
			respuesta.put("mensaje", "Error al realizar la consulta sobre la base de datos");
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getStackTrace().toString()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(user==null) {	// Hemos buscado un id que no existe
			respuesta.put("mensaje", "El Identificador buscado no existe");
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		// Hemos buscado el ID y SI que existe
		return new ResponseEntity<Usuario>(user,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario user) {
		user.setJoinDate(new Date().toString());
		userService.save(user);
		return user;
	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario user, @PathVariable int id) {
		Usuario userActual = userService.findById(id);
		userActual.setDescription(user.getDescription());
		userActual.setPics(user.getPics());
		userActual.setUsername(user.getUsername());
		userActual.setAvatar(user.getAvatar());
		userService.save(userActual);
		return userActual;
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable int id){
		/*Usuario userActual = userService.findById(id);
		userService.delete(userActual);*/
		userService.deleteById(id);
	}
	
}
