package br.com.curso.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Categoria;
import br.com.curso.jpa.modelo.Conta;
import br.com.curso.jpa.modelo.Movimentacao;
import br.com.curso.jpa.modelo.TipoMovimentacao;

public class TestaRelacMovCatg {

	public static void main(String[] args) {

		Categoria catg1 = new Categoria("Viajem");
		Categoria catg2 = new Categoria("Negocios");

		Conta conta = new Conta();
		conta.setId(2L);

		Movimentacao mov = new Movimentacao();
		mov.setData(LocalDateTime.now());
		mov.setDesccricao("Viajem a Nova York - EUA");
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setData(LocalDateTime.now());
		mov.setValor(new BigDecimal(3250.0));
		mov.setCategorias(Arrays.asList(catg1, catg2));
		mov.setConta(conta);

		Movimentacao mov2 = new Movimentacao();
		mov2.setData(LocalDateTime.now().plusDays(1));
		mov2.setDesccricao("Viajem a Lisboa - PORT");
		mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov2.setData(LocalDateTime.now());
		mov2.setValor(new BigDecimal(5250.0));
		mov2.setCategorias(Arrays.asList(catg1, catg2));
		mov2.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(catg1);
		em.persist(catg2);
		em.persist(mov);
		em.persist(mov2);
		em.getTransaction().commit();
		em.close();

	}

}
