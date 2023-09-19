package com.gestion.vehiculos.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.vehiculos.Entity.Usuarios;
import com.gestion.vehiculos.Repository.UsuarioRepository;
import com.gestion.vehiculos.modelo.JwtRequest;
import com.gestion.vehiculos.modelo.JwtResponse;
import com.gestion.vehiculos.modelo.usuario;
import com.gestion.vehiculos.service.UsuarioService;
import com.gestion.vehiculos.service.impl.UserDetailsServiceImpl;
import com.gestion.vehiculos.utilities.md5;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/api/v1/auth")
	public JwtResponse login(@RequestBody JwtRequest jwtRequest) throws Exception {
		Usuarios usuario = new Usuarios();
		md5 md5 = new md5();
		String pass = md5.getMd5(jwtRequest.getPassword());

		Usuarios usuarioEncontrado = usuarioService.buscarUsuarioPorUsuarioYContraseña(jwtRequest.getUsername(), pass);

		if (usuarioEncontrado != null) {
			String token = getJWTToken(jwtRequest.getUsername());
			JwtResponse user = new JwtResponse();
			user.setToken(token);
			return user;
		} else {
			JwtResponse user = new JwtResponse();
			user.setToken("Ocurrio un error al momento de generar el token, o usuario no existe");
			return user;
		}

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return token;
	}
	
    @GetMapping("/api/v1/actual-usuario")
    public Usuarios obtenerUsuarioActual(Principal principal){
        return (Usuarios) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}
