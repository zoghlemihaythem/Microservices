package com.esprit.secondapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esprit.secondapp.entities.Stock;

public interface StockRepository extends MongoRepository<Stock, String>{

}
