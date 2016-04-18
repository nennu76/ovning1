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
	 * Testar att funktionen fungerar och räknar rätt med både positiva/negativa tal 
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
	 * Första testar funktionen fungerar med 2 enkla, positiva tal
	 * Den andra är inget bra testfall, men har med det för att få förklaring. Det borde
	 * ju hanteras i produktkoden iaf.  
	 */
	
	@Test 
	public void testMultiply(){
		assertEquals("Testar att multiplicera 2 enkla, positiva tal", 12, lab.multiply(6, 2));
	}
	
	/*
	 * Har med denna nedan för den förbryllar mig. Undrade vad som skulle hända om talet skulle
	 * bli större än vad som ryms i en int. Det är kanske så här Java fungerar? Jag vet inte...
	 * Testet blir grönt, men resultatet är ju inte alls korrekt (Eclipse tillåter inte mig
	 * att skriva rätt svar heller eftersom det då är större än en int).
	 */
	
	@Test 
	public void testMultiplyBig(){
		assertEquals("Testar att multiplicera 2 int som blir större än int", 1705032704, lab.multiply(6, 1000000000));
	}
	
	/*
	 * Test av Devide-metoden
	 * Första ett enkelt test att den fungerar som den ska
	 * Den andra testar att om resultatet är ett decimaltal så returneras ändå en int
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
