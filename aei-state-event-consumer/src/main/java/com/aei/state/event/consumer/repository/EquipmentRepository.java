/**
 * 
 */
package com.aei.state.event.consumer.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE equipment S SET S.AVAILABLE=:available WHERE S.mac = :mac", nativeQuery = true)
	void updateEquipmentState(@Param("available") boolean available, @Param("mac") String mac);

}
