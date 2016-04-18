package se.iths;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;


/*Testteknik = white-box (eftersom vi inte heller har n�got annat �n koden att tillg�)
 *Testerna avser att uppn� 100% kodt�ckning, metod f�r metod. Dvs om alla tester k�rs s� 
 *ska all kod ha t�ckts. Quote-metoden �r den enda med villkor, d�r k�rs metoden s�
 *m�nga g�nger att alla alternativ rimligen kommer att testas (annars falerar testet).
 *Niv�n �r enhetstester, kan inte f� det till n�t annat. Vet inte om man kan kombinera fler
 *metoder i samma och kalla det integrationstest? Test av countern touchar v�l i s� fall det?
 * alt. att man k�r en metod med andra metoder som argument? 
 * Har anv�nt Assert-metoderna Equals, NotEquals och NotNull, d�r de passade.
 */

public class Lab1Test {

	Lab1 lab;
	 
	@Before
	public void setup(){
		lab = new Lab1();
	}
	
	/*Test av Add-metoden
	 * Testar att funktionen fungerar och r�knar r�tt med b�de positiva/negativa tal 
	 */

	@Test 
	public void testAdd() {
		assertEquals("Testar att addera 2 enkla, positiva tal", 11, lab.add(5,6));
	}
	
	@Test 
	public void testAddNeg(){
		assertEquals("Testar att addera 2 enkla, negativa tal", -15, lab.add(-5,-10));
	}
	
	/* Test av Subtract-metoden
	 * Tre enkla test att funktionen fungerar som den ska och r�knar r�tt oavsett placering
	 * eller negativa/positiva tal
	 */
	
	@Test
	public void testSub(){
		assertEquals("Testar att subtrahera 2 enkla, positiva tal", 4, lab.subtract(12, 8));
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
	
	/*
	 * Test av Reverse-metoden
	 * F�rst att den str�ng som skickas in verkligen returneras spegelv�nt
	 * Sen att om en tom str�ng skickas in s� returneras en tom utan inv�ndningar. Vilket
	 * man iofs kanske b�r kolla upp om det ska g�.
	 * Den sista f�r att testa att om null skickas in s� kastas exception. Borde hanteras
	 * i produktkoden.
	 */
	
	@Test
	public void testReverse(){
		assertEquals("Testar att en korrekt str�ng returneras spegelv�nt", "netsnuR airaM",  lab.reverse("Maria Runsten"));
	}
	
	@Test
	public void testReverseEmpty(){
		assertEquals("Testar att en tom str�ng ocks� returerar en tom", "", lab.reverse(""));
	}
	
	@Test (expected = NullPointerException.class)
	public void testReverseNull() throws NullPointerException{
			lab.reverse(null);
	}
	
	/*
	 * Test av Quote-metoden
	 * F�rst bara om den returnerar n�got �verhuvudtaget dvs inte null
	 * Sedan att alla citat verkligen slumpas fram, s� det inte �r samma hela tiden, kan
	 * vara ett problem med random-metoden.
	 * Testar dock inte att talet som slumpas verkligen returnerar "r�tt" citat. 
	 */
	
	@Test
	public void testQuote(){
		assertNotNull("Testar om det returneras n�got annat �n null", lab.quote());
	}
	
	@Test
	public void testQuoteRandom(){
		String s;
		int[] list = new int[8];
		for(int i = 0; i<8 ;i++){
			list[i]=0;
		}
		for(int i = 0; i<100; i++){
			s = lab.quote();
				
			if(s.equals("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein")){
				list[0]++;
			}
			else if(s.equals("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare")){
				list[1]++;			
			}
			else if(s.equals("You must be the change you wish to see in the world. - Mahatma Gandhi")){
				list[2]++;
			}
			else if(s.equals("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.")){
				list[3]++;
			}
			else if(s.equals("Choose a job you love, and you will never have to work a day in your life. - Confucius")){
				list[4]++;
			}
			else if(s.equals("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde")){
				list[5]++;
			}
			else if(s.equals("Without music, life would be a mistake. - Friedrich Nietzsche")){
				list[6]++;
			}
			else if(s.equals("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams")){
				list[7]++;
			}
		}
		for(int i = 0; i<8; i++){
			assertNotEquals("Testar att alla citat returneras minst 1 g�ng av 100", 0, list[i]);
		}
		
	}

	/*
	 * Eftersom test ska kunna k�ras separat eller i obest�md ordning, s� kollas startv�rdet
	 * innan man k�r igenom alla metoder (vilket �r 6st) och ser att v�rdet p� 
	 * countern �kat med 6. Alla metoder tas med f�r f� 100% kodt�ckning.
	 * Att testa countern vid varje testfall �r inte bra, man vill i dem bara testa
	 * att just den funktionen fungerar. 
	 * P� det s�tt jag valt att testa den, kan den ocks� falera, om n�gon av metoderna
	 * g�r det. P� s� s�tt �r denna beroende av att de andra testfallen g�r igenom. 
	 */
	@Category(SmokeCategory.class)
	@Test
	public void testCounter(){
		int startCounter = lab.getCounter();
		lab.add(23, 42);
		lab.subtract(56, 32);
		lab.multiply(4, 5);
		lab.divide(16, 4);
		lab.reverse("?tt�r ned rank�R");
		lab.quote();
		assertEquals("Testar att counter r�knar r�tt antal metoder som k�rs", 6, lab.getCounter()-startCounter);
	}
}
