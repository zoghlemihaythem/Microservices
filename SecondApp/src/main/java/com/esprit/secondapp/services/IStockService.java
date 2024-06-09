package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Stock;

public interface IStockService {

	Stock addStock(Stock stock);

	Stock updateStock(String id, Map<String, Object> stock);

	List<Stock> getAllStock();

	Stock getStockById(String id);

	void deleteStockById(String id);

}
