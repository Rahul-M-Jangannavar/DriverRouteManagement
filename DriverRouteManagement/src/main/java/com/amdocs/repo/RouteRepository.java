package com.amdocs.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.entity.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

	
}
