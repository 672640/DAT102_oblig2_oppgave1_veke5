package oppgåve1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import src.ParantesSjekker;
import src.StabelADT;
class ParentesSjekkerTest {
//Treng eigentleg ikkje dette her
	private StabelADT<String> stabel;
	@Test
	void startParentesStemmer() {
		ParantesSjekker startParantes = new ParantesSjekker();
		assertEquals(true, startParantes.erStartParentes('('));
		assertEquals(true, startParantes.erStartParentes('['));
		assertEquals(true, startParantes.erStartParentes('{'));
	}

	@Test
	void sluttParentesStemmer() {
		ParantesSjekker sluttParantes = new ParantesSjekker();
		assertEquals(true, sluttParantes.erSluttParentes(')'));
		assertEquals(true, sluttParantes.erSluttParentes(']'));
		assertEquals(true, sluttParantes.erSluttParentes('}'));
	}
	
	@Test
	void liktMedParantesarPåBeggeSidene() {
		ParantesSjekker parantesPar = new ParantesSjekker();
		assertEquals(true, parantesPar.erParentesPar('(', ')'));
		assertEquals(true, parantesPar.erParentesPar('[', ']'));
		assertEquals(true, parantesPar.erParentesPar('{', '}'));
		
	}

	@Test
	void parantesaneStemmer() {
		ParantesSjekker parantesStemmer = new ParantesSjekker();
		assertEquals(true, parantesStemmer.sjekkParenteser("(([å])l)"));
	}
//Til hit
	
//Real shit
	@Test
	void foersteEksempel() {
		ParantesSjekker foersteEksempel = new ParantesSjekker();
		assertEquals(true, foersteEksempel.sjekkParenteser("{ [ ( ) ] }"));
	}
	
	@Test
	void andreEksempel() {
		ParantesSjekker andreEksempel = new ParantesSjekker();
		assertEquals(false, andreEksempel.sjekkParenteser("{ [ ( ) } ]"));
	}
	
	@Test
	void tredjeEksempel() {
		ParantesSjekker tredjeEksempel = new ParantesSjekker();
		assertEquals(false, tredjeEksempel.sjekkParenteser("[ ( ) ] }"));
	}
	
	@Test
	void fjerdeEksempel() {
		ParantesSjekker fjerdeEksempel = new ParantesSjekker();
		assertEquals(false, fjerdeEksempel.sjekkParenteser("{ [ ( ] ) }"));
	}
	
	@Test
	void femteEksempel() {
		ParantesSjekker femteEksempel = new ParantesSjekker();
		assertEquals(true, femteEksempel.sjekkParenteser("class HelloWorld {\r\n"
				+ "public static void main(String[] args) {\r\n"
				+ "System.out.println(\"Hello World!\");\r\n"
				+ "}\r\n"
				+ "}"));
	}
}
