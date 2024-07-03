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

import com.esprit.firstapp.entities.Article;
import com.esprit.firstapp.entities.ArticleWithStockDTO;
import com.esprit.firstapp.services.IArticleService;
import com.esprit.firstapp.services.StockClient;

@RestController
@RequestMapping("/api/Article")

public class ArticleController {

	@Autowired
	private IArticleService articleService;

	@GetMapping("/articles")
	public List<ArticleWithStockDTO> getAllTutorials() {
		return articleService.getAllArticle();

	}

	@PostMapping("/save")
	public ArticleWithStockDTO save(@RequestBody ArticleWithStockDTO article) {
		return articleService.addArticle(article);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		articleService.deleteArticleById(id);

	}

	@GetMapping("/getbyid/{id}")
	public ArticleWithStockDTO GetById(@PathVariable("id") Long id) {
		return articleService.getArticleById(id);
	}

	@PatchMapping("/update/{id}")
	public Article patchUpdateStock(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return articleService.updateArticle(id, updates);

	}

}
