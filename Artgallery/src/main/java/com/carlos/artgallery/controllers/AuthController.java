package com.carlos.artgallery.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.artgallery.models.entities.Usuario;
import com.carlos.artgallery.models.services.IUsuarioService;

@RestController
@RequestMapping("/auth")

public class AuthController {

	@Autowired
	private IUsuarioService usersService;

	@PostMapping("/login")
	public ResponseEntity<ResponseLoginDto> login(@RequestBody UsuarioLoginDto userLogin) throws NoSuchAlgorithmException {
		Usuario user = usersService.login(userLogin.getEmail(), userLogin.getPassword());

		if (user != null) {
			return ResponseEntity.ok().body(new ResponseLoginDto(getToken(user)));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody UsuarioRegisterDto userDto) throws NoSuchAlgorithmException {
		usersService.register(userDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/validate")
	public void validateToken() {
	}

	private String getToken(Usuario user) {
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("userid", user.getUserId());
		data.put("username", user.getUsername());
		data.put("authorities", Arrays.asList("ROLE_USER"));

		String token = Jwts.builder().setId("springEventos").setSubject(user.getName()).addClaims(data)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET_KEY).compact();

		return token;
	}

}
