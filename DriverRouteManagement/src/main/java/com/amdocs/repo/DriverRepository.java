package com.amdocs.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.entity.DriverEntity;
@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Integer> {

	//findByxxx
	//Customized queries
}

