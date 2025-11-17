package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Pagamento;

public class PagamentoDAO extends PersistenciaJPA {
    
    public List<Pagamento> listaPagamentos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Pagamento> query = em.createQuery("SELECT p FROM Pagamento p", Pagamento.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pagamento> buscarPorFormaPagamento(String formaPagamento) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Pagamento> query = em.createQuery("SELECT p FROM Pagamento p WHERE p.formaPagamento = :formaPagamento", Pagamento.class);
            query.setParameter("formaPagamento", formaPagamento);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}