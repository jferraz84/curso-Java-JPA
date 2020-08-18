package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		// Aqui está em estado Transient
		Conta conta = new Conta();
		conta.setTitular("Marli");
		conta.setAgencia(2421);
		conta.setNumero(9876);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Aqui passa de Transient -> Managed para sincronização com BD
		em.persist(conta);
		em.remove(conta);  // Removendo uma conta

		em.getTransaction().commit();
	}

}
