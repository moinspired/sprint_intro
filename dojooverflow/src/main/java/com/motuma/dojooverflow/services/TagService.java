package com.motuma.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.motuma.dojooverflow.models.Tag;
import com.motuma.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	

}
