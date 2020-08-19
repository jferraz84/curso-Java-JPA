package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;
import br.com.curso.jpa.modelo.Movimentacao;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
		Conta conta = movimentacao.getConta();
		int qntMoviment = conta.getMovimentacoes().size();
		
		System.out.println("Quantidade de movimentações: " + qntMoviment);
		System.out.println("Titular da conta: " + conta.getTitular());

	}

}
