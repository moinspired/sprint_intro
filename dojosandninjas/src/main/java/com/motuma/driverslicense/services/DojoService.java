package com.motuma.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.driverslicense.models.Dojo;
import com.motuma.driverslicense.repositories.DojoRepository;
import com.motuma.driverslicense.repositories.*;
@Service
public class DojoService {
	private DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> getDojos(){
		return dojoRepo.findAll();
	}
	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepo.findOne(id);
	}
	public void updateDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	public void deleteDojo(Long id) {
		dojoRepo.delete(id);
	}
	
}
