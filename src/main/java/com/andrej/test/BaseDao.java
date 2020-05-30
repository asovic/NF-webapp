package com.andrej.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class BaseDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    // Stores a new order:
    @Transactional
    public void save(Order order) {
        em.persist(order);
    }

    // Retrieves all orders (TODO):
    public List<Order> getAllOrders() {
        TypedQuery<Order> query = em.createQuery(
            "SELECT g FROM order_test g ORDER BY g.id", Order.class);
        return query.getResultList();
    }
	}