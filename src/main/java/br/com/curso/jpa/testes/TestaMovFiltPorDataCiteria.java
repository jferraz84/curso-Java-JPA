package br.com.curso.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Movimentacao;
import br.com.curso.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovFiltPorDataCiteria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDao.getMovimentacoesFiltradasPorData(null, null, null);
		
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição -> " + movimentacao.getDesccricao());
			System.out.println("Valor -> " + movimentacao.getValor());
			System.out.println("---------------------------------------");
			
		}

	}

}
