package com.spain.cvet.filter;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	// Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    public static void addAuthentication(HttpServletResponse res, String username) throws IOException {

        String token = Jwts.builder()
            .setSubject(username)
                
            // Vamos a asignar un tiempo de expiracion de 30 minutos = 1800000 
            //1 minuto = 60000
            // solo con fines demostrativos en el video que hay al final
            .setExpiration(new Date(System.currentTimeMillis() + 1800000))
            
            // Hash con el que firmaremos la clave
            .signWith(SignatureAlgorithm.HS512, "@cVet")
            .compact();

        //agregamos al encabezado el token
        res.addHeader("Authorization", "Bearer " + token);
    }

    // Método para validar el token enviado por el cliente
    public static Authentication getAuthentication(HttpServletRequest request) {
        
        // Obtenemos el token que viene en el encabezado de la peticion
        String token = request.getHeader("Authorization");
        
        try {
        	// si hay un token presente, entonces lo validamos
            if (token != null) {
                String user = Jwts.parser()
                        .setSigningKey("@cVet")
                        .parseClaimsJws(token.replace("Bearer", "")) //este metodo es el que valida
                        .getBody()
                        .getSubject();

                // Recordamos que para las demás peticiones que no sean /login
                // no requerimos una autenticacion por username/password 
                // por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
                return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
            }
		} catch (ExpiredJwtException e) {
			//e.printStackTrace();
		}
        
        return null;
    }

}
