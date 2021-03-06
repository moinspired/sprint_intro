package com.motuma.world.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.world.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
