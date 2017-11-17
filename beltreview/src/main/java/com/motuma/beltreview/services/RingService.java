package com.motuma.beltreview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motuma.beltreview.models.Ring;
import com.motuma.beltreview.repositories.RingRepository;


@Service
public class RingService {
	
	@Autowired
	private RingRepository ringRepo;
	

	public void create(Ring ring) {
		ringRepo.save(ring);
	}

	public ArrayList<Ring> getRings(){
		return (ArrayList<Ring>) ringRepo.findAll();
	}
	public Ring getRing(long id) {
		return (Ring) ringRepo.findOne(id);
	}
	public void update(Ring ring) {
		ringRepo.save(ring);
	}
	public void destroy(long id) {
		ringRepo.delete(id);
	}
}
