package br.unicamp.ic.inf335.app.trab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnuncianteBeanTest {

	private static final ProdutoBean produto1 = new ProdutoBean();
	private static final ProdutoBean produto2 = new ProdutoBean();
	private static final ProdutoBean produto3 = new ProdutoBean();
	private static final AnuncioBean anuncioBean1 = new AnuncioBean();
	private static final AnuncioBean anuncioBean2 = new AnuncioBean();
	private static final AnuncioBean anuncioBean3 = new AnuncioBean();
	private static final AnuncianteBean anuncianteBean = new AnuncianteBean();

	@BeforeAll
	public static void setupBeforeClass() throws Exception{
		produto1.setCodigo("001");
		produto1.setNome("Produto menor valor");
		produto1.setDescricao("Vamos testar");
		produto1.setValor(10.00);
		produto1.setEstado("Valido");
		System.out.println("Produto prrenchido: " + produto1.getNome());
		produto2.setCodigo("002");
		produto2.setNome("Produto medio valor");
		produto2.setDescricao("Vamos testar de novo");
		produto2.setValor(20.0);
		produto2.setEstado("Valido");
		System.out.println("Produto preenchido: " + produto2.getNome());
		produto3.setCodigo("003");
		produto3.setNome("Produto maior valor");
		produto3.setDescricao("Mais um produto");
		produto3.setValor(30.0);
		produto3.setEstado("Valido");
		System.out.println("Produto preenchido: " + produto3.getNome());
		
		anuncioBean1.setProduto(produto1);
		anuncioBean1.setDesconto(0.5);
		System.out.println("Anuncio 1 agora tem o produto:" + produto1.getNome());
		anuncioBean2.setProduto(produto2);
		anuncioBean2.setDesconto(0.5);
		System.out.println("Anuncio 2 agora tem o produto:" + produto2.getNome());
		anuncioBean3.setProduto(produto3);
		anuncioBean3.setDesconto(0.5);
		System.out.println("Anuncio 3 agora tem o produto:" + produto3.getNome());
		
		anuncianteBean.setAnuncios(new ArrayList<AnuncioBean>());
		anuncianteBean.setCPF("123");
		anuncianteBean.setNome("IC");
		System.out.println("Anunciante com CPF e nome preenchido:" + anuncianteBean.getNome() );
	}

	@AfterEach
	public void clearAnuncios() {
		anuncianteBean.setAnuncios(new ArrayList<AnuncioBean>());
	}

	@Test
	public void testAddAnuncio() {
		anuncianteBean.addAnuncio(anuncioBean1);
		assertEquals(anuncianteBean.getAnuncios().size(), 1);
	}

	@Test
	public void testRemoveAnuncio() {
		anuncianteBean.addAnuncio(anuncioBean1);
		anuncianteBean.removeAnuncio(0);
		assertEquals(anuncianteBean.getAnuncios().size(), 0);
	}

	@Test
	public void testRemoveMultiplosAnuncios() {
		anuncianteBean.addAnuncio(anuncioBean1);
		anuncianteBean.addAnuncio(anuncioBean2);
		anuncianteBean.addAnuncio(anuncioBean3);
		anuncianteBean.removeAnuncio(1);
		assertEquals(anuncianteBean.getAnuncios().size(), 2);
		assertEquals(anuncianteBean.getAnuncios().get(1), anuncioBean3);
	}

	@Test
	public void testMediaAnuncios() {
		anuncianteBean.addAnuncio(anuncioBean1);
		anuncianteBean.addAnuncio(anuncioBean2);
		anuncianteBean.addAnuncio(anuncioBean3);
		Double mediaEsperada = (anuncioBean1.getValor() + anuncioBean2.getValor() + anuncioBean3.getValor())/3.0; 
		assertEquals(mediaEsperada, anuncianteBean.valorMedioAnuncios());
	}

}
