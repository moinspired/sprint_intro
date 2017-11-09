package com.motuma.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.driverslicense.models.Dojo;
import com.motuma.driverslicense.models.Ninja;
import com.motuma.driverslicense.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> getNijas(){
		return ninjaRepo.findAll();
	}
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public Ninja getNija(Long id) {
		return ninjaRepo.findOne(id);
	}
	public void updateNija(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	public void deleteNija(Long id) {
		ninjaRepo.delete(id);
	}

}
