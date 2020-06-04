package com.andrej.test.repository;

import com.andrej.test.entities.OrderEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	List<OrderEntity> findByUsername(String username);
}
