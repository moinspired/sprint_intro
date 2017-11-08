package com.motuma.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.lookify.models.Song;
import com.motuma.lookify.services.SongService;

@Controller
public class Songs {
	private final SongService songService;
	
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("song") Song song, Model model) {
		model.addAttribute("languages", songService.getSongs());
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String home(@ModelAttribute("song") Song Song, Model model) {
		model.addAttribute("songs", songService.getSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String show(@ModelAttribute("song") Song song) {
		return "addSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song,  BindingResult result) {
		if(result.hasErrors()) {
			return "addSong.jsp";
		}
		else {
			songService.create(song);
			return "redirect:/";
		}
	}
	@RequestMapping("song/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.getSong(id);
		model.addAttribute("song", song);
		model.addAttribute("id", id);
		return "show.jsp";
	}
	
	@RequestMapping("song/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		songService.destroy(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam("artist") String artist) {
		artist = artist.replace(" ", "");
		System.out.println(artist);
		return "redirect:/search/".concat(artist);
	}
	
	@RequestMapping("/search/{artist}")
	public String searchResult(@PathVariable("artist") String artist, Model model) {
		artist = splitString(artist);
		System.out.println(artist);
		model.addAttribute("artist", artist);
		List<Song> songs = songService.searchByArtist(artist);
		
		// if query returns empty list
		if(songs.isEmpty()) {
			System.out.println("empty list");
			return "dashboard";
		} else {
			model.addAttribute("songs", songs);
			return "result.jsp";			
		}
	}
	
	//helper method...if the method
	public String splitString(String artist) {
		int index = getUppserCaseIndex(artist);
		String temp = artist;
		return temp.substring(0, index) + " " +  artist.substring(index, artist.length());
	}
	
	public int getUppserCaseIndex(String artist) {
		String temp;
		for(int i=1; i<artist.length(); i++) {
			if(Character.isUpperCase(artist.charAt(i))) {
				return i;
			}
		}
		return 0;
	}
}
