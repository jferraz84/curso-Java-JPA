package br.com.curso.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;
import br.com.curso.jpa.modelo.Movimentacao;
import br.com.curso.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("João");
		conta.setNumero(135791);
		conta.setAgencia(2421);
		conta.setSaldo(145.5);
		
		Movimentacao mov = new Movimentacao();
		mov.setData(LocalDateTime.now());
		mov.setDesccricao("Churrascaria");
		mov.setValor(new BigDecimal(200.0));
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		
		em.close();
		
		
		
	}

}
