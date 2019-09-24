package com.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

	/**
	 * Gera o hash utilizando o {@link BCryptPasswordEncoder}
	 * @param senha
	 * @return String
	 */
	public static String geradorBCrypt(String senha) {
		if(senha == null) {
			return senha;
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(senha);
		
		return encode;
	}
	
	/**
	 * varifica se a senha é valida utilizando {@link BCryptPasswordEncoder}
	 * @param senha
	 * @param senhaEncoded
	 * @return boolean
	 */
	public static boolean senhaValida(String senha, String senhaEncoded) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		boolean matches = bCryptPasswordEncoder.matches(senha, senhaEncoded);
		
		return matches;
	}
}
