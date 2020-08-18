package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaDoJorge = em.find(Conta.class, 2L);
		
		em.getTransaction().begin();
		
		contaDoJorge.setSaldo(2250.8);
		
		em.getTransaction().commit();
		
	}

}
