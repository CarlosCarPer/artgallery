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

import com.carlos.artgallery.models.entities.Comment;
import com.carlos.artgallery.models.services.ICommentService;

@CrossOrigin(origins= {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = {"Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"})
@RestController
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/comments")
	public List<Comment> index(){
		return commentService.findAll();
	}
	
	@GetMapping("/comments/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Comment comment = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();	
		
		try {
			comment = commentService.findById(id);
		} catch (Exception e) {  // Base de datos inaccesible
			respuesta.put("mensaje", "Error al realizar la consulta sobre la base de datos");
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getStackTrace().toString()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(comment==null) {	// Hemos buscado un id que no existe
			respuesta.put("mensaje", "El Identificador buscado no existe");
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		// Hemos buscado el ID y SI que existe
		return new ResponseEntity<Comment>(comment,HttpStatus.OK);
	}
	
	@PostMapping("/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment create(@RequestBody Comment comment) {
		comment.setCommentDate(new Date().toString());
		commentService.save(comment);
		return comment;
	}
	
	@PutMapping("/comments/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment update(@RequestBody Comment comment, @PathVariable int id) {
		Comment commentActual = commentService.findById(id);
		commentActual.setComment(comment.getComment());
		commentActual.setCommentary(comment.getCommentary());
		commentActual.setComments(comment.getComments());
		commentActual.setCommentDate(comment.getCommentDate());
		commentActual.setCommentId(comment.getCommentId());
		commentActual.setLikes(comment.getLikes());
		commentActual.setUsuario(comment.getUsuario());
		commentService.save(commentActual);
		return commentActual;
	}
	
	@DeleteMapping("/comments/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable int id){
		/*Comment commentActual = commentService.findById(id);
		commentService.delete(commentActual);*/
		commentService.deleteById(id);
	}
	
}
