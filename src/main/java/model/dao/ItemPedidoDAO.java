package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.ItemPedido;

public class ItemPedidoDAO extends PersistenciaJPA {
    
    public List<ItemPedido> listaItensPedido() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ItemPedido> query = em.createQuery("SELECT i FROM ItemPedido i", ItemPedido.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ItemPedido> buscarPorPedido(int idPedido) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ItemPedido> query = em.createQuery("SELECT i FROM ItemPedido i WHERE i.idPedido.id = :idPedido", ItemPedido.class);
            query.setParameter("idPedido", idPedido);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}