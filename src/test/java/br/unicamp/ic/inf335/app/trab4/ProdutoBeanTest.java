package br.unicamp.ic.inf335.app.trab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ProdutoBeanTest {

	private static final ProdutoBean produto1 = new ProdutoBean();
	private static final ProdutoBean produto2 = new ProdutoBean();
	
	@BeforeAll
	public static void setupBeforeClass() throws Exception{
		produto1.setCodigo("001");
		produto1.setNome("Produto maior valor");
		produto1.setDescricao("Vamos testar");
		produto1.setValor(10.10);
		produto1.setEstado("Valido");
		System.out.println("Produto prrenchido: " + produto1.getNome());
		produto2.setCodigo("002");
		produto2.setNome("Produto menor valor");
		produto2.setDescricao("Vamos testar de novo");
		produto2.setValor(5.5);
		produto2.setEstado("Valido");
		System.out.println("Produto preenchido: " + produto2.getNome());
	}
	
	@Test
	public void testCompareToMaiorParaMenor() {
		int resultado = produto1.compareTo(produto2);
		assertEquals(1, resultado);
	}
	
	@Test
	public void testCompareToMenorParaMaior() {
		int resultado = produto2.compareTo(produto1);
		assertEquals(-1, resultado);
	}

}
