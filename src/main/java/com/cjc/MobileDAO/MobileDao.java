package com.cjc.MobileDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjc.Entity.Mobile;

@Repository
public interface MobileDao extends JpaRepository<Mobile, Integer>{
	
	List<Mobile> findByMobileName(String mobileName);
	
	@Query(
			 "SELECT mob FROM Mobile mob " +
					 "WHERE (:mobileBrand IS NULL OR mob.mobileBrand = :mobileBrand) " +
					 "AND (:minmobilePrice IS NULL OR mob.mobilePrice >= :minmobilePrice) " +
					 "AND (:maxmobilePrice IS NULL OR mob.mobilePrice <= :maxmobilePrice)"
			
			)
	
	List<Mobile> filterMobiles(
			
			@Param("mobileBrand") String mobileBrand,
			@Param("minmobilePrice") Double minmobilePrice,
			@Param("maxmobilePrice") Double maxmobilePrice	
		);

}
