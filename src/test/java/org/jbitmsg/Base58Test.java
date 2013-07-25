package org.jbitmsg;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.jbitmsg.lib.Base58;
import org.junit.Test;

public class Base58Test {

	@Test
	public void testNumberToAlpha() {
		Base58 base = new Base58();
		assertEquals("1", base.numberToAlpha(BigInteger.ZERO));
		assertEquals("2", base.numberToAlpha(BigInteger.ONE));
		assertEquals("R3kttRWPrU3P2",
				base.numberToAlpha(new BigInteger("2000000000000000000000")));
	}

	@Test
	public void testAlphaToNumber() {
		Base58 base = new Base58();
		assertEquals(BigInteger.ZERO, base.alphaToNumber("1"));
		assertEquals(BigInteger.ONE, base.alphaToNumber("2"));
		assertEquals(new BigInteger("6727999999998678853982528"),
				base.alphaToNumber("R3kttBJRWPrU3P2"));
	}

}
