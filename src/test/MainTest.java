package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.Main;

public class MainTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));
 	}

  	@After
	public void tearDown() throws IOException {
		outContent.close();
	} 

	@Test
	public void testPrincipal1(){
		String a = "3 10 20 30\n";
    	String esperado = "80\n2 3 \n";
		Scanner leitura = new Scanner(a);
		Main.principal(leitura);
		System.setOut(new PrintStream(outContent));
		assertEquals(esperado,outContent.toString());
  	}
  
	@Test
	public void testPrincipal2(){
			String a = "3 10 30 20\n";
			String esperado = "60\n2 \n";
			Scanner leitura = new Scanner(a);
			Main.principal(leitura);
			System.setOut(new PrintStream(outContent));
			assertEquals(esperado,outContent.toString());
	}
	
	@Test
	public void testPrincipal3(){
			String a = "3 30 10 20\n";
			String esperado = "100\n1 2 \n";
			Scanner leitura = new Scanner(a);
			Main.principal(leitura);
			System.setOut(new PrintStream(outContent));
			assertEquals(esperado,outContent.toString());
	}
	
	@Test
	public void testPrincipal4(){
			String a = "5 80 50 10 5 15\n";
			String esperado = "290\n1 2 \n";
			Scanner leitura = new Scanner(a);
			Main.principal(leitura);
			System.setOut(new PrintStream(outContent));
			assertEquals(esperado,outContent.toString());
	}

	@Test
	public void testTempoGasto(){
		int[] Total = {160,80,80};
		int N = 3;
		int minutos = Main.TempoGasto(Total, N);
		assertEquals(80, minutos);
	}

	@Test
	public void testAndarMaquina(){
		int[] Total = {290,290,490,730,990};
		int N = 5;
		int Minutos = 290;
    	String expected = "1 2 \n";
    	Main.AndarMaquina(Total, N, Minutos);
		assertEquals(expected, outContent.toString());
	}

}
