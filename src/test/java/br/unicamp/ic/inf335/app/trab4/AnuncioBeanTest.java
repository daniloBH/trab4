package br.unicamp.ic.inf335.app.trab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnuncioBeanTest {

	private static final AnuncioBean anuncioBean = new AnuncioBean();
	private static final ProdutoBean produto1 = new ProdutoBean();

	@BeforeAll
	public static void setupBeforeClass() throws Exception{
		produto1.setCodigo("001");
		produto1.setNome("Produto menor valor");
		produto1.setDescricao("Vamos testar");
		produto1.setValor(10.0);
		produto1.setEstado("Valido");
		System.out.println("Produto preenchido: " + produto1.getNome());
		anuncioBean.setProduto(produto1);
		System.out.println("Anuncio agora tem o produto:" + produto1.getNome());
	}

	@Test
	public void testValorDescontoTotal() {
		anuncioBean.setDesconto(1.0);
		Double valorComDesconto = anuncioBean.getValor();
		assertEquals(valorComDesconto, (Double) 0.0);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	public void testValorDescontoParcial(Double desconto, Double valorEsperado) {
		anuncioBean.setDesconto(desconto);
		Double valorComDesconto = anuncioBean.getValor();
		assertEquals(valorEsperado, valorComDesconto);
	}


	private static Stream<Arguments> provideParameters() {
		return Stream.of(
					Arguments.of(0.1, 9.0),
					Arguments.of(0.3, 7.0),
					Arguments.of(0.5, 5.0),
					Arguments.of(0.8, 2.0)
		);
	}

}
