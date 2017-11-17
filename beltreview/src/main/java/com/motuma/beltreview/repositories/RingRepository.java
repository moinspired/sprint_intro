package com.motuma.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.beltreview.models.Ring;

@Repository
public interface RingRepository extends CrudRepository <Ring, Long>{
	 List<Ring> findAll();
	    
}
