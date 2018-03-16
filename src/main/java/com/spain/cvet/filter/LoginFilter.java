package com.spain.cvet.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {

		// obtenemos el body de la peticion que asumimos viene en formato JSON
		BufferedReader body = req.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;
	    while ((line = body.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();

		// Asumimos que el body tendrá el siguiente JSON {"username":"ask",
		// "password":"123"}
		// Realizamos un mapeo a nuestra clase User para tener ahi los datos
	    JSONObject json = null;
	    try {
	    	JSONParser parser = new JSONParser();
			 json = (JSONObject)parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    User user = new User(json.get("username").toString(), json.get("password").toString());

		// Finalmente autenticamos
		// Spring comparará el user/password recibidos
		// contra el que definimos en la clase SecurityConfig
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),
				user.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		// Si la autenticacion fue exitosa, agregamos el token a la respuesta
		JwtUtil.addAuthentication(res, auth.getName());
	}

	class User {
		private String username;
		private String password;
		
		public User(String username, String password){
			this.username = username;
			this.password = password;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

}
