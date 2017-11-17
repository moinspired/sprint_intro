package com.motuma.beltreview.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motuma.beltreview.models.Ring;
import com.motuma.beltreview.models.Team;
import com.motuma.beltreview.repositories.TeamRepository;


@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;
	

	public void create(Team team) {
		teamRepository.save(team);
	}

	public ArrayList<Team> getTeams(){
		return (ArrayList<Team>) teamRepository.findAll();
	}
	public Team getTeam(long id) {
		return (Team) teamRepository.findOne(id);
	}
	public void update(Team team) {
		teamRepository.save(team);
	}
	public void destroy(long id) {
		teamRepository.delete(id);
	}

}
