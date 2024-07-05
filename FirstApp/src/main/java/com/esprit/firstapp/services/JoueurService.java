package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.firstapp.entities.Joueur;
import com.esprit.firstapp.entities.JoueurWithEquipeDTO;
import com.esprit.firstapp.entities.EquipeDTO;
import com.esprit.firstapp.mappers.JoueurMappers;
import com.esprit.firstapp.repository.JoueurRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JoueurService implements IJoueurService {
	@Autowired
	private EquipeClient stockClient;

	@Autowired
	private JoueurRepository joueurRepository;

	@Override
	public JoueurWithEquipeDTO addJoueur(JoueurWithEquipeDTO articleDto) {
		joueurRepository.save(JoueurMappers.mapToEntity(articleDto));
		return articleDto;

	}

	@Override
	public List<JoueurWithEquipeDTO> getAllJoueur() {

		return joueurRepository.findAll().stream().map(article -> JoueurMappers.mapToDto(article))
				.collect(Collectors.toList());
	}

	@Override
	public JoueurWithEquipeDTO getJoueurById(Long id) {
		Joueur joueur = joueurRepository.findById(id).get();

		// OpenFeign
		EquipeDTO stockDTO = stockClient.getById(joueur.getId_Equipe());

		// RestTemplate
		// StockDTO stockDTO =getById(article.getId_stock());
		return JoueurMappers.mapToDto(joueur, stockDTO);
	}

	@Override
	public Joueur updateJoueur(Long id, Map<String, Object> article) {
		Joueur existingArticle = joueurRepository.findById(id).get();

		if (existingArticle == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : article.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingArticle.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingArticle, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return joueurRepository.save(existingArticle);
	}

	@Override
	public void deleteJoueurById(Long id) {
		joueurRepository.deleteById(id);

	}

	public EquipeDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, EquipeDTO.class);
	}

}
