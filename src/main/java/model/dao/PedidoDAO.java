package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Pedido;

public class PedidoDAO extends PersistenciaJPA {
    
    public List<Pedido> listaPedidos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pedido> buscarPorStatus(String status) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p WHERE p.status = :status", Pedido.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}