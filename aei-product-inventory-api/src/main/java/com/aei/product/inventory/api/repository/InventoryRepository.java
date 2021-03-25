/**
 * 
 */
package com.aei.product.inventory.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<StoreInventoryModel, Long> {

	@Query(value = "select i.id as inventoryid, p.name as productname, p.description as productdesc, p.price_min, p.price_list, ps.name as productcategory, e.available as productavailability, s.id as storeid, s.name as storename, s.available as storeavailability "
			+ "from product p, inventory i, equipment e, store s, product_category ps "
			+ "where p.id=i.product_id and s.id = i.store_id and e.id = i.equipment_id and p.category = ps.id and s.id = :id", nativeQuery = true)
	List<StoreInventoryModel> getInventoryByStore(@Param("id") long id);

	@Query(value = "select i.id as inventoryid, p.name as productname, p.description as productdesc, p.price_min, p.price_list, ps.name as productcategory, e.available as productavailability, s.id as storeid, s.name as storename, s.available as storeavailability "
			+ "from product p, inventory i, equipment e, store s, product_category ps "
			+ "where p.id=i.product_id and s.id = i.store_id and e.id = i.equipment_id and p.category = ps.id and i.id = :id", nativeQuery = true)
	StoreInventoryModel getByInventory(@Param("id") long id);

}
