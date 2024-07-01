package com.esprit.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.firstapp.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
