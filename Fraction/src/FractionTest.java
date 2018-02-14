import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {
	private Fraction f3_5, fm2_7, f0_2;
	
	// Returns true if f1 is equal to f2
	
	public boolean equals(Fraction f1, Fraction f2) {
		return (f1.getNumerator()*f2.getDenominator()) == (f1.getDenominator()*f2.getNumerator());
	}
	
	/**
     * This '@Before' method is ran before every '@Test' method
    */
   @Before
   public void setUp() throws Exception {
      f3_5 = new Fraction(3, 5);
      fm2_7 = new Fraction(-2, 7);
      f0_2 = new Fraction(0, 2);
   }

	@Test
	public void testFraction() {
	    assertEquals(3, f3_5.getNumerator());
	    assertEquals(5, f3_5.getDenominator());
	    assertEquals(-2, fm2_7.getNumerator());
	    assertEquals(7, fm2_7.getDenominator());	
	}

	@Test
	public void testGetNumerator() {
	    assertEquals(3, f3_5.getNumerator());
	    assertEquals(-2, fm2_7.getNumerator());
	    assertEquals(0, f0_2.getNumerator());
	}

	@Test
	public void testGetDenominator() {
	    assertEquals(5, f3_5.getDenominator());
	    assertEquals(7, fm2_7.getDenominator());	
	    assertEquals(2, f0_2.getDenominator());	
	}

	@Test
	public void testReciprocal() {
		Fraction f = f3_5.reciprocal();
		assertEquals(f.getNumerator(), 5);
		assertEquals(f.getDenominator(), 3);
		
		f = f0_2.reciprocal();
		assertEquals(f.getNumerator(), 2);
		assertEquals(f.getDenominator(), 0);	
		
		f = fm2_7.reciprocal();
		assertEquals(f.getNumerator(), -7);
		assertEquals(f.getDenominator(), 2);		
	}

	@Test
	public void testAdd() {
		Fraction f = f3_5.add(fm2_7);
		assertTrue(equals(f, new Fraction(11, 35)));
		
		f = fm2_7.add(f0_2);
		assertTrue(equals(f, fm2_7));
	}
	
	@Test
	public void testSubtract() {
		Fraction f = f3_5.subtract(fm2_7);
		assertTrue(equals(f, new Fraction(31, 35)));
		
		f = f0_2.subtract(fm2_7);
		assertTrue(equals(f, new Fraction(2, 7)));
	}
	
	@Test
	public void testMultiply() {
		Fraction f = f3_5.multiply(fm2_7);
		assertTrue(equals(f, new Fraction(-6, 35)));
		assertTrue(f.getDenominator() > 0);		// only numerator can be negative
		
		f = fm2_7.multiply(f0_2);
		assertTrue(equals(f, f0_2));		
		assertTrue(f.getDenominator() > 0);		// only numerator can be negative
	}
	
	@Test
	public void testDivide() {
		Fraction f = f3_5.divide(fm2_7);
		assertTrue(equals(f, new Fraction(-21, 10)));		
		assertTrue(f.getDenominator() > 0);		// only numerator can be negative
	}
	
	@Test
	public void testEquals() {
		assertFalse(f3_5.equals(fm2_7));
		assertTrue(f3_5.equals(new Fraction(6,10)));
		assertTrue(f0_2.equals(new Fraction(0,10)));
	}
	
	@Test
	public void testToString() {
		assertTrue(f3_5.toString().equals("3/5"));
		assertTrue(fm2_7.toString().equals("-2/7"));
		
		boolean zerof = f0_2.toString().equals("0/2") || f0_2.toString().equals("0/1");
		assertTrue(zerof);
	}
	
}
