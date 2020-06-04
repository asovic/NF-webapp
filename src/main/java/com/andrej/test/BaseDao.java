//package com.andrej.test;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Component;
//
//import entities.BottleEntity;
//import entities.OrderEntity;
//
//@Component
//public class BaseDao {
//    // Injected database connection:
//    @PersistenceContext
//    private EntityManager em;
//
//    // Stores a new order:
//    @Transactional
//    public void save(OrderEntity order) {
//        em.persist(order);
//    }
//
//    // TODO Retrieves all orders by user:
//    public List<OrderEntity> getAllOrdersByUser(String username) {
//        TypedQuery<OrderEntity> query = em.createQuery(
//            "SELECT o FROM order_test o WHERE o.username = :username", OrderEntity.class);
//        return query.setParameter("username", username).getResultList();
//    	}
//    
//    // TODO Get order details by order_id
//    public List<BottleEntity> getAllBottlesByOrder(int id) {
//    	TypedQuery<BottleEntity> query = em.createQuery(
//    			"SELECT b FROM bottle b WHERE o.order_id = :order_id", BottleEntity.class);
//    	return query.setParameter("order_id", id).getResultList();
//    	}
//    
//	}