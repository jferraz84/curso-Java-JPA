package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		Conta conta = new Conta();
		conta.setTitular("Aline");
		conta.setNumero(1357);
		conta.setAgencia(2468);
		conta.setSaldo(1750.5);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("Id da conta da Heloyse: " + conta.getId());
		conta.setSaldo(2500.6);
		
		em2.getTransaction().begin();
		
		em2.merge(conta);
		
		em2.getTransaction().commit();
	}

}
