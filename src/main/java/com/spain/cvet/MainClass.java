package com.spain.cvet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass {

	public static void main(String[] args) {
		String password = "1";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
	}

}
