package se.iths;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lab1FitnesseTest {
	
	private int number1, number2;
	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	Lab1 lab;
	 
	@Before
	public void setup(){
		lab = new Lab1();
	}
	
	/*Test av Add-metoden
	 * Testar att funktionen fungerar och r�knar r�tt med b�de positiva/negativa tal 
	 */

	
	public int testAdd() {
		lab = new Lab1();
		return lab.add(number1,number2);
	}
	
	public int testSub(){
		lab = new Lab1();
		return lab.subtract(number1, number2);
	}
	
	@Test
	public void testSubNeg(){
		assertEquals("Testar att subtrahera 2 enkla, negativa tal", -4, lab.subtract(-12, -8));
	}
	
	@Test
	public void testSubSmallWithBigger(){
		assertEquals("Testar att subtrahera 2 enkla, positiva tal med negativt resultat", -4, lab.subtract(8, 12));
	}
	
	/*
	 * Test av Multiply-metoden
	 * F�rsta testar funktionen fungerar med 2 enkla, positiva tal
	 * Den andra �r inget bra testfall, men har med det f�r att f� f�rklaring. Det borde
	 * ju hanteras i produktkoden iaf.  
	 */
	
	@Test 
	public void testMultiply(){
		assertEquals("Testar att multiplicera 2 enkla, positiva tal", 12, lab.multiply(6, 2));
	}
	
	/*
	 * Har med denna nedan f�r den f�rbryllar mig. Undrade vad som skulle h�nda om talet skulle
	 * bli st�rre �n vad som ryms i en int. Det �r kanske s� h�r Java fungerar? Jag vet inte...
	 * Testet blir gr�nt, men resultatet �r ju inte alls korrekt (Eclipse till�ter inte mig
	 * att skriva r�tt svar heller eftersom det d� �r st�rre �n en int).
	 */
	
	@Test 
	public void testMultiplyBig(){
		assertEquals("Testar att multiplicera 2 int som blir st�rre �n int", 1705032704, lab.multiply(6, 1000000000));
	}
	
	/*
	 * Test av Devide-metoden
	 * F�rsta ett enkelt test att den fungerar som den ska
	 * Den andra testar att om resultatet �r ett decimaltal s� returneras �nd� en int
	 * Den tredje testar att dela med 0 och att exception kastas. Borde hanteras i 
	 * produktkoden.
	 */
	
	@Test 
	public void testDevide(){
		assertEquals("Testar att dela 2 enkla, positiva tal", 3, lab.divide(6, 2));
	}
	
	@Test 
	public void testDevideToDouble(){
		assertEquals("Testar att dela till decimaltal", 0, lab.divide(3, 4));
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivideZero() throws ArithmeticException{
		lab.divide(6, 0);
	}
	
}
