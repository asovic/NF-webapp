package com.andrej.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class BaseDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void save(Order order) {
        em.persist(order);
    }

    // Retrieves all the guests:
    public List<Order> getAllGuests() {
        TypedQuery<Order> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Order.class);
        return query.getResultList();
    }
	}