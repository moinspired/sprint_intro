package com.motuma.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.motuma.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	
}
