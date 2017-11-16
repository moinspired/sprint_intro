package com.motuma.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.dojooverflow.models.Question;
import com.motuma.dojooverflow.services.QuestionService;
import com.motuma.dojooverflow.services.TagService;

@Controller
public class Main {
	private final QuestionService questionService;
	private final TagService tagService;
	
	public Main(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("questionModel") Question question, Model model) {
		return "new.jsp";
	}
	@PostMapping("/questions/new")
	public String create(@RequestParam("question") String question, @RequestParam("tags") String tags) {
		System.out.println(question);
		System.out.println(tags);
		System.out.println(splitTats(tags));
		for(String tag: splitTats(tags)) {
			System.out.println(tag);
		}
		return "redirect:/questions/new";
	}
	
	//this helper fucntion creats list of tags given a stiring
	public List<String> splitTats(String str) {
		List<String> tags = new ArrayList<String>();
		str = str.replace(" ", "");
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ',') {
				tags.add(str.substring(count, i));
				count = i+1;
			}
		}
		for(int i=str.length()-1; i > 0; i--) {
			if(str.charAt(i) == ',') {
				String val = str.substring(i + 1, str.length());
				tags.add(val);
				break;
			}
		}
		
		return tags;
	}
}
