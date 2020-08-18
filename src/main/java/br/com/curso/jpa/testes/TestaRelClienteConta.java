package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Cliente;
import br.com.curso.jpa.modelo.Conta;

public class TestaRelClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cli = new Cliente();
		cli.setNome("Luis");
		cli.setEndereco("Rua: Clovis Lordano, 140");
		cli.setProfissao("Programador");
		cli.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
		em.close();

	}

}
