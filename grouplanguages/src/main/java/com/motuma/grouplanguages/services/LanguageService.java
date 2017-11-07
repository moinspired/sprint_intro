package com.motuma.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.grouplanguages.models.Language;

@Service
public class LanguageService {
	 List<Language> languages = new ArrayList(Arrays.asList(
     		new Language("Java", "James Gosling", "1.8"),
     		new Language("Python", "Guido van Rossum", "3.6")
     		));
	 public List<Language> allLangauge(){
		 return languages;
	 }
	  public Language findLanguageByIndex(int index) {
	        if (index < languages.size()){
	            return languages.get(index);
	        }else{
	            return null;
	        }
	    }
	  public void addLanguage(Language language) {
	        languages.add(language);
	    }
	  public void destroyLanguage(int id) {
		  if(id < languages.size()) {
			  languages.remove(id);
		  }
	  }
	  public void updateLanguage(int id, Language language) {
		  if (id < languages.size()) {
			  languages.set(id, language);
		  }
	  }
}
