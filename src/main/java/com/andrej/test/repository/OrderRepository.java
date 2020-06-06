package com.andrej.test.repository;

import com.andrej.test.entities.OrderEntity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	List<OrderEntity> findByUsername(String username);
	
	//query za brisanje
	@Transactional
	@Modifying
	@Query(value = "delete from order_test o where o.id = :oid and o.username = :username")
	void deleteByIdAndUsername(Long oid, String username);
}