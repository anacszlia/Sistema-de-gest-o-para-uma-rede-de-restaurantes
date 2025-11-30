package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Produto;

public class ProdutoDAO extends PersistenciaJPA {
    
    public List<Produto> listaProdutos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
    
    public List<Produto> buscarPorCategoria(String categoria) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.categoria = :categoria", Produto.class);
            query.setParameter("categoria", categoria);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Produto buscarPorId(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void atualizar(Produto produto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
}