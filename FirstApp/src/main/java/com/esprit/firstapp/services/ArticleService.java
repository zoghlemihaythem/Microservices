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

import com.esprit.firstapp.entities.Article;
import com.esprit.firstapp.entities.ArticleWithStockDTO;
import com.esprit.firstapp.entities.StockDTO;
import com.esprit.firstapp.mappers.ArticleMappers;
import com.esprit.firstapp.repository.ArticleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private StockClient stockClient;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public ArticleWithStockDTO addArticle(ArticleWithStockDTO articleDto) {
		 articleRepository.save(ArticleMappers.mapToEntity(articleDto));
		return articleDto;
		
	}

	@Override
	public List<ArticleWithStockDTO> getAllArticle() {

		return articleRepository.findAll().stream().map(article -> ArticleMappers.mapToDto(article))
				.collect(Collectors.toList());
	}

	@Override
	public ArticleWithStockDTO getArticleById(Long id) {
		Article article = articleRepository.findById(id).get();
		
		//OpenFeign
		StockDTO stockDTO = stockClient.getById(article.getId_stock());
		
		//RestTemplate
		//StockDTO stockDTO =getById(article.getId_stock());
		return ArticleMappers.mapToDto(article, stockDTO);
	}


	@Override
	public Article updateArticle(Long id, Map<String, Object> article) {
		Article existingArticle = articleRepository.findById(id).get();

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
		return articleRepository.save(existingArticle);
	}

	@Override
	public void deleteArticleById(Long id) {
		articleRepository.deleteById(id);

	}

	public StockDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, StockDTO.class);
	}

}
