package com.motuma.lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.lookify.models.Song;
import com.motuma.lookify.repositories.SongRepository;

@Service
public class SongService {
private SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	public void create(Song song) {
		songRepo.save(song);
	}
	public List<Song> getSongs(){
		return songRepo.findAll();
	}
	public Song getSong(long id) {
		return (Song) songRepo.findOne(id);
	}
	public void update(Song song) {
		songRepo.save(song);
	}
	public void destroy(long id) {
		songRepo.delete(id);
	}
	public List<Song> searchByArtist(String artist){
		List<Song> songs = songRepo.findAll();
		List<Song> newlist = new ArrayList<Song>();
		for(Song song: songs) {
			if(song.getArtist().equals(artist)) {
				newlist.add(song);
			}
		}
		return newlist;
	}
}
