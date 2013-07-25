package org.jbitmsg.lib;

import java.math.BigInteger;

public class Base58 {
	private final char[] BASE58_CHARS = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
			.toCharArray();

	public String numberToAlpha(BigInteger number) {
		char[] buffer = new char[200];
		int index = 0;
		do {
			buffer[index++] = BASE58_CHARS[number.mod(
					BigInteger.valueOf(BASE58_CHARS.length)).intValue()];
			number = number.divide(BigInteger.valueOf(BASE58_CHARS.length));
		} while (number.compareTo(BigInteger.ZERO) > 0);
		return new String(buffer, 0, index);
	}

	public BigInteger alphaToNumber(String text) {
		char[] chars = text.toCharArray();
		BigInteger result = BigInteger.ZERO;
		BigInteger multiplier = BigInteger.ONE;
		for (int index = 0; index < chars.length; index++) {
			char c = chars[index];
			int digit;
			if (c >= '1' && c <= '9') {
				digit = c - '1';
			} else if (c >= 'A' && c < 'I') {
				digit = (c - 'A') + 9;
			} else if (c > 'I' && c < 'O') {
				digit = (c - 'J') + 17;
			} else if (c > 'O' && c <= 'Z') {
				digit = (c - 'P') + 22;
			} else if (c >= 'a' && c < 'l') {
				digit = (c - 'a') + 33;
			} else if (c > 'l' && c <= 'z') {
				digit = (c - 'l') + 43;
			} else {
				throw new IllegalArgumentException("Illegal character found: '"
						+ c + "'");
			}

			result = result.add(multiplier.multiply(BigInteger.valueOf(digit)));
			multiplier = multiplier.multiply(BigInteger
					.valueOf(BASE58_CHARS.length));
		}
		return result;
	}
}
