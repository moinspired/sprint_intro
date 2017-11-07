package com.motuma.languagesreloaded.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.motuma.languagesreloaded.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
}
