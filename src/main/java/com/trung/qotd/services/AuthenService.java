package com.trung.qotd.services;

import com.trung.qotd.utils.StringValidator;

public class AuthenService {
	private static final int MAX_LENGTH = 86;

	private static boolean usernameTooLong(String username) {
		return username.length() > MAX_LENGTH;
	}

	public static boolean validUsername(String username) {
		if (usernameTooLong(username)) {
			return false;
		}
		
		if (StringValidator.stringHasSpecialCharacter(username)) {
			return false;
		}
		
		return true;
	}
}
