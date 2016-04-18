package se.iths;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;


/*Testteknik = white-box (eftersom vi inte heller har något annat än koden att tillgå)
 *Testerna avser att uppnå 100% kodtäckning, metod för metod. Dvs om alla tester körs så 
 *ska all kod ha täckts. Quote-metoden är den enda med villkor, där körs metoden så
 *många gånger att alla alternativ rimligen kommer att testas (annars falerar testet).
 *Nivån är enhetstester, kan inte få det till nåt annat. Vet inte om man kan kombinera fler
 *metoder i samma och kalla det integrationstest? Test av countern touchar väl i så fall det?
 * alt. att man kör en metod med andra metoder som argument? 
 * Har använt Assert-metoderna Equals, NotEquals och NotNull, där de passade.
 */

public class Lab1Test {

	Lab1 lab;
	 
	@Before
	public void setup(){
		lab = new Lab1();
	}
	
	/*Test av Add-metoden
	 * Testar att funktionen fungerar och räknar rätt med både positiva/negativa tal 
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
	 * Tre enkla test att funktionen fungerar som den ska och räknar rätt oavsett placering
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
	
	/*
	 * Test av Reverse-metoden
	 * Först att den sträng som skickas in verkligen returneras spegelvänt
	 * Sen att om en tom sträng skickas in så returneras en tom utan invändningar. Vilket
	 * man iofs kanske bör kolla upp om det ska gå.
	 * Den sista för att testa att om null skickas in så kastas exception. Borde hanteras
	 * i produktkoden.
	 */
	
	@Test
	public void testReverse(){
		assertEquals("Testar att en korrekt sträng returneras spegelvänt", "netsnuR airaM",  lab.reverse("Maria Runsten"));
	}
	
	@Test
	public void testReverseEmpty(){
		assertEquals("Testar att en tom sträng också returerar en tom", "", lab.reverse(""));
	}
	
	@Test (expected = NullPointerException.class)
	public void testReverseNull() throws NullPointerException{
			lab.reverse(null);
	}
	
	/*
	 * Test av Quote-metoden
	 * Först bara om den returnerar något överhuvudtaget dvs inte null
	 * Sedan att alla citat verkligen slumpas fram, så det inte är samma hela tiden, kan
	 * vara ett problem med random-metoden.
	 * Testar dock inte att talet som slumpas verkligen returnerar "rätt" citat. 
	 */
	
	@Test
	public void testQuote(){
		assertNotNull("Testar om det returneras något annat än null", lab.quote());
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
			assertNotEquals("Testar att alla citat returneras minst 1 gång av 100", 0, list[i]);
		}
		
	}

	/*
	 * Eftersom test ska kunna köras separat eller i obestämd ordning, så kollas startvärdet
	 * innan man kör igenom alla metoder (vilket är 6st) och ser att värdet på 
	 * countern ökat med 6. Alla metoder tas med för få 100% kodtäckning.
	 * Att testa countern vid varje testfall är inte bra, man vill i dem bara testa
	 * att just den funktionen fungerar. 
	 * På det sätt jag valt att testa den, kan den också falera, om någon av metoderna
	 * gör det. På så sätt är denna beroende av att de andra testfallen går igenom. 
	 */
	@Category(SmokeCategory.class)
	@Test
	public void testCounter(){
		int startCounter = lab.getCounter();
		lab.add(23, 42);
		lab.subtract(56, 32);
		lab.multiply(4, 5);
		lab.divide(16, 4);
		lab.reverse("?ttär ned rankäR");
		lab.quote();
		assertEquals("Testar att counter räknar rätt antal metoder som körs", 6, lab.getCounter()-startCounter);
	}
}
