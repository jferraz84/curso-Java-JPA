package br.com.curso.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.curso.jpa.modelo.MediaComData;

public class MovimentacaoDao {

	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {

//		String jpql = "select new br.com.curso.jpa.modelo.MediaComData(avg(m.valor), day(m.data), "
//				+ "month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<MediaComData> query = em.createQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {

		String jpql = "select sum(m.valor) from Movimentacao m";

		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();

		return somaDasMovimentacoes;
	}
}