package Cibertec.pe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Cibertec.pe.Dto.AuthRequest;
import Cibertec.pe.Models.UsuarioCredential;
import Cibertec.pe.Service.AuthService;

@RequestMapping("/auth")
@RestController
public class UsuarioController {
	
	@Autowired
	private  AuthService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UsuarioCredential user) {
		return service.saveUser(user);
	}
	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authReuqest) {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReuqest.getUsername(),authReuqest.getPassword()));                       
	if(authentication.isAuthenticated()) {
		return service.generateToken(authReuqest.getUsername());
	}else {
		throw new RuntimeException("Acceso invalido");
	}
		
	}
	
	@GetMapping("/validate")
	public String Validateoken(@RequestParam("token")String token) {
		service.validateToken(token);
		return "Token Valido";
	}
	

}
