package br.com.curso.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.MediaComData;
import br.com.curso.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaProjecao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();

		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println(
					"A m�dia das movimentacoes do dia " + resultado.getDia() + "/" + resultado.getMes() + " �: " + resultado.getValor());
		}
	}

}
