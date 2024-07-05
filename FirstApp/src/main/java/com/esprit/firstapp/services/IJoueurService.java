package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Joueur;
import com.esprit.firstapp.entities.JoueurWithEquipeDTO;

public interface IJoueurService {
	
	JoueurWithEquipeDTO addJoueur(JoueurWithEquipeDTO joueur);

	Joueur updateJoueur(Long id, Map<String, Object> joueur);

	List<JoueurWithEquipeDTO> getAllJoueur();

	JoueurWithEquipeDTO getJoueurById(Long id);

	void deleteJoueurById(Long id);

}
