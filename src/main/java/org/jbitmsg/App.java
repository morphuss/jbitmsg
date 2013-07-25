package org.jbitmsg;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.jbitmsg.lib.Base58;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(final String[] args) throws Exception {
		Base58 base58 = new Base58();
		String text = "Testkey2000";
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] sha1hash = new byte[32];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		sha1hash = md.digest();

		BigInteger number = new BigInteger(1, sha1hash);

		// System.out.println(org.bouncycastle.asn1.sec.SECNamedCurves
		// .getByName("secp256k1").getCurve()
		// .createPoint(BigInteger.ONE, BigInteger.TEN, true).hashCode());
		System.out.println(number);
		System.out.println(base58.numberToAlpha(number));
		System.out.println(base58.alphaToNumber(base58.numberToAlpha(number)));

	}

}
