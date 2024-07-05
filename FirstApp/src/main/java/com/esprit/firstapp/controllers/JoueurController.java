package com.esprit.firstapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.firstapp.entities.Joueur;
import com.esprit.firstapp.entities.JoueurWithEquipeDTO;
import com.esprit.firstapp.services.IJoueurService;
import com.esprit.firstapp.services.EquipeClient;

@RestController
@RequestMapping("/api/Joueur")

public class JoueurController {

	@Autowired
	private IJoueurService joueurService;

	@GetMapping("/articles")
	public List<JoueurWithEquipeDTO> getAllTutorials() {
		return joueurService.getAllJoueur();

	}

	@PostMapping("/save")
	public JoueurWithEquipeDTO save(@RequestBody JoueurWithEquipeDTO joueur) {
		return joueurService.addJoueur(joueur);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		joueurService.deleteJoueurById(id);

	}

	@GetMapping("/getbyid/{id}")
	public JoueurWithEquipeDTO GetById(@PathVariable("id") Long id) {
		return joueurService.getJoueurById(id);
	}

	@PatchMapping("/update/{id}")
	public Joueur patchUpdateStock(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return joueurService.updateJoueur(id, updates);

	}

}
