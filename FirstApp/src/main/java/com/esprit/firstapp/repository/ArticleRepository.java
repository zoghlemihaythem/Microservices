package com.esprit.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.firstapp.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
