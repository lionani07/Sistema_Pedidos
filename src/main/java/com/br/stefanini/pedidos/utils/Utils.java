package com.br.stefanini.pedidos.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Utils {

	public static String encriptar(String senha) throws NoSuchAlgorithmException {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(senha.getBytes());
			byte[] hash = md.digest();
			StringBuffer senhaEncrip = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				senhaEncrip.append(Integer.toHexString(hash[i] & 0xff));
			}
			return senhaEncrip.toString();

		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException(e.getMessage());
		}

	}

}
