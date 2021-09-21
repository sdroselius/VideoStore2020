package com.skilldistillery.bootmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.bootmvc.data.FilmDAO;
import com.skilldistillery.jpavideostore.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = "/")
	public String index(Model model) {
		List<Film> films = filmDao.findAll();
		model.addAttribute("films", films);
		return "index"; // if using a ViewResolver.
	}

	@RequestMapping(path = "getFilm.do")
	public String showFilm(Integer fid, Model model) {
		Film film = filmDao.findById(fid);
		model.addAttribute("film", film);
		return "film/show";
	}

}
