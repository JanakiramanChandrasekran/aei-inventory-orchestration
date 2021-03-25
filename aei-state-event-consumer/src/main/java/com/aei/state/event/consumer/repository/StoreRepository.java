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
public interface StoreRepository extends JpaRepository<Store, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE store S SET S.AVAILABLE=:available WHERE S.id = :id", nativeQuery = true)
	void updateStoreState(@Param("available") boolean available, @Param("id") long id);

}
