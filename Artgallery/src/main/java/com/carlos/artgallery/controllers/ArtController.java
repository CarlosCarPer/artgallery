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

import com.carlos.artgallery.models.entities.Art;
import com.carlos.artgallery.models.services.IArtService;
import com.carlos.artgallery.models.services.IUsuarioService;

@CrossOrigin(origins= {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = {"Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"})
@RestController
public class ArtController {
	
	@Autowired
	private IArtService artService;
	
	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/arts")
	public List<Art> index(){
		return artService.findAll();
	}
	
	@GetMapping("/arts/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Art art = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();	
		
		try {
			art = artService.findById(id);
		} catch (Exception e) {  // Base de datos inaccesible
			respuesta.put("mensaje", "Error al realizar la consulta sobre la base de datos");
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getStackTrace().toString()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(art==null) {	// Hemos buscado un id que no existe
			respuesta.put("mensaje", "El Identificador buscado no existe");
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		// Hemos buscado el ID y SI que existe
		return new ResponseEntity<Art>(art,HttpStatus.OK);
	}
	
	@PostMapping("/arts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Art create(@RequestBody Art art, @PathVariable int id) {
		art.setUsuario(userService.findById(id));
		art.setArtDate(new Date().toString());
		art.setAuthor(userService.findById(id).getUsername());
		art.setLikes(0);
		artService.save(art);
		return art;
	}
	
	@PutMapping("/arts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Art update(@RequestBody Art art, @PathVariable int id) {
		Art artActual = artService.findById(id);
		artActual.setTags(art.getTags());
		artActual.setTitle(art.getTitle());
		artActual.setDescription(art.getDescription());
		artService.save(artActual);
		return artActual;
	}
	
	@DeleteMapping("/arts/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable int id){
		/*Art artActual = artService.findById(id);
		artService.delete(artActual);*/
		artService.deleteById(id);
	}
	
}
