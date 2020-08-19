package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		System.out.println("A médis das movimentações é: " + dao.getSomaDasMovimentacoes());
		
		
	}

}
