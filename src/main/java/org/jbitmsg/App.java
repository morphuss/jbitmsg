package org.jbitmsg;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) throws Exception {
        String text = "Testkey";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("UTF-8"), 0, text.length());
        sha1hash = md.digest();
        
        BigInteger number = new BigInteger(1,sha1hash);
        System.out.println(sha1hash[3]);
        System.out.println(number.toString(16));
        

        System.out.println(org.bouncycastle.asn1.sec.SECNamedCurves.getByName("secp256k1").getCurve()
                        .createPoint(BigInteger.ONE, BigInteger.TEN, true).hashCode());

    }


}
