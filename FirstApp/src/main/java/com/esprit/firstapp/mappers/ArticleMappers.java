package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Article;
import com.esprit.firstapp.entities.ArticleWithStockDTO;
import com.esprit.firstapp.entities.StockDTO;

public class ArticleMappers {

	public static ArticleWithStockDTO mapToDto(Article article) {

		ArticleWithStockDTO articleDTO = ArticleWithStockDTO.builder().id(article.getId()).name(article.getName())
				.size(article.getSize()).id_stock(article.getId_stock()).build();
		return articleDTO;
	}

	public static ArticleWithStockDTO mapToDto(Article article, StockDTO stockDTO) {

		ArticleWithStockDTO articleDTO = ArticleWithStockDTO.builder().id(article.getId()).name(article.getName())
				.size(article.getSize()).id_stock(article.getId_stock()).stockdto(stockDTO).build();

		return articleDTO;
	}

	public static Article mapToEntity(ArticleWithStockDTO articleDTO) {
		Article article = Article.builder().id(articleDTO.getId()).name(articleDTO.getName()).size(articleDTO.getSize())
				.id_stock(articleDTO.getStockdto().getId()).build();
		return article;

	}

}
