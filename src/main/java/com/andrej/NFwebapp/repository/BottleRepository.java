package com.andrej.NFwebapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andrej.NFwebapp.entities.BottleEntity;

public interface BottleRepository extends JpaRepository<BottleEntity, Long>{
	
	@Query("select b " + 
			"from bottle b inner join order_test ot on b.orderid = ot.id " + 
			"where b.orderid = :order_id and ot.username = :username")
	List<BottleEntity> findByOrderid(Long order_id, String username);
	
	@Query("select b from bottle b where b.orderid =:oid")
	List<BottleEntity> findByOid(Long oid);
}
