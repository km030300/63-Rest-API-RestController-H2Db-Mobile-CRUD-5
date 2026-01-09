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
	
}
