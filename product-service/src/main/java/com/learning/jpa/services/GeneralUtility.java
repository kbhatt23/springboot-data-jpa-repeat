package com.learning.jpa.services;

import org.springframework.util.StringUtils;

public class GeneralUtility {
	// an integer can not have 0 length
	// an integer can have each cahrs only between 0 to 9
	public static boolean isInteger(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
}
