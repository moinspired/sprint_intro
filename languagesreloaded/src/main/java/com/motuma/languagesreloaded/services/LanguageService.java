package com.motuma.languagesreloaded.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.languagesreloaded.models.Language;
import com.motuma.languagesreloaded.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> getLanguages(){
		return languageRepo.findAll();
	}
	public void addLanguage(Language lang) {
		languageRepo.save(lang);
	}
	
	public Language getLanguage(Long id) {
		return languageRepo.findOne(id);
	}
	public void updateLanguage(Language language) {
		languageRepo.save(language);
	}
	public void deleteLanguage(Long id) {
		languageRepo.delete(id);
	}
}
