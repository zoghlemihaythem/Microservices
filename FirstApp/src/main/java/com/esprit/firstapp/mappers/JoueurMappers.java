package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Joueur;
import com.esprit.firstapp.entities.JoueurWithEquipeDTO;
import com.esprit.firstapp.entities.EquipeDTO;

public class JoueurMappers {

	public static JoueurWithEquipeDTO mapToDto(Joueur joueur) {

		JoueurWithEquipeDTO articleDTO = JoueurWithEquipeDTO.builder().id(joueur.getId()).name(joueur.getName())
				.age(joueur.getAge()).id_equipe(joueur.getId_Equipe()).build();
		return articleDTO;
	}

	public static JoueurWithEquipeDTO mapToDto(Joueur joueur, EquipeDTO equipeDTO) {

		JoueurWithEquipeDTO articleDTO = JoueurWithEquipeDTO.builder().id(joueur.getId()).name(joueur.getName())
				.age(joueur.getAge()).id_equipe(joueur.getId_Equipe()).equipedto(equipeDTO).build();

		return articleDTO;
	}

	public static Joueur mapToEntity(JoueurWithEquipeDTO equipeDTO) {
		Joueur article = Joueur.builder().id(equipeDTO.getId()).name(equipeDTO.getName()).age(equipeDTO.getAge())
				.id_Equipe(equipeDTO.getEquipedto().getId()).build();
		return article;

	}

}
