package com.trung.qotd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
	public static boolean stringHasSpecialCharacter(String str) {
		Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		
		return matcher.find();
	}
}