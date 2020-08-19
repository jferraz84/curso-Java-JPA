package br.com.curso.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.curso.jpa.modelo.Categoria;
import br.com.curso.jpa.modelo.Movimentacao;

public class TesteJPQLMovCateg {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		Categoria categ = new Categoria();
		categ.setId(2L);

		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categ);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categorias: " + movimentacao.getCategorias());
			System.out.println("Descrição: " + movimentacao.getDesccricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("--------------------------------------------");

		}

	}
}
