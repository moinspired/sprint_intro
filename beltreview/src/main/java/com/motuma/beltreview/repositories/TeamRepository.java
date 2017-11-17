package com.motuma.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.motuma.beltreview.models.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{
	List<Team> findAll();
}
