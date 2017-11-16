package com.motuma.world.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.world.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

}
