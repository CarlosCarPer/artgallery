package com.carlos.artgallery.controllers;

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

import com.carlos.artgallery.models.entities.Account;
import com.carlos.artgallery.models.services.IAccountService;
import com.carlos.artgallery.models.services.IUsuarioService;

@CrossOrigin(origins= {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = {"Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"})
@RestController
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/accounts")
	public List<Account> index(){
		return accountService.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Account account = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();	
		
		try {
			account = accountService.findById(id);
		} catch (Exception e) {  // Base de datos inaccesible
			respuesta.put("mensaje", "Error al realizar la consulta sobre la base de datos");
			respuesta.put("error", e.getMessage().concat(" : ").concat(e.getStackTrace().toString()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(account==null) {	// Hemos buscado un id que no existe
			respuesta.put("mensaje", "El Identificador buscado no existe");
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		// Hemos buscado el ID y SI que existe
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	@PostMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Account create(@RequestBody Account account, @PathVariable int id) {
		account.setUsuario(userService.findById(id));
		accountService.save(account);
		return account;
	}
	
	@PutMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Account update(@RequestBody Account account, @PathVariable int id) {
		Account accountActual = accountService.findById(id);
		accountActual.setPass(account.getPass());
		accountActual.setPlatform(account.getPlatform());
		accountActual.setUrl(account.getUrl());
		accountActual.setUsername(account.getUsername());
		accountService.save(accountActual);
		return accountActual;
	}
	
	@DeleteMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable int id){
		/*Account accountActual = accountService.findById(id);
		accountService.delete(accountActual);*/
		accountService.deleteById(id);
	}
	
}
