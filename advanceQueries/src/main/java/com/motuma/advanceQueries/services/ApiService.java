package com.motuma.advanceQueries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.advanceQueries.models.Dojo;
import com.motuma.advanceQueries.repositories.DojoRepository;
import com.motuma.advanceQueries.repositories.NinjaRepository;

@Service
public class ApiService {
	private DojoRepository dojoRepo;
	private NinjaRepository ninjaRepo;
	
	public ApiService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	//get all DojoNames
	public List<Dojo> allDojoNames(){
		return dojoRepo.getAllDojoNames();
	}
	
	//passing params and filter (still retrieves a list)
	public Dojo getDojo(Long id) {
		return dojoRepo.getDojoWhereId(id);
	}
	

}
