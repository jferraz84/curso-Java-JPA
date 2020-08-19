package br.com.curso.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select sum(m.valor) from Movimentacao m";
		String jpql = "select avg(m.valor) from Movimentacao m";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double somadasMov = query.getSingleResult();
		
		//System.out.println("A soma das movimentações é: " + somadasMov);
		System.out.println("A médis das movimentações é: " + somadasMov);
		
		
	}

}
