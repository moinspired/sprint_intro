package com.motuma.world.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.world.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

}
