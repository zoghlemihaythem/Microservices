package com.esprit.firstapp.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.firstapp.entities.StockDTO;

@FeignClient(name = "stock", url = "http://localhost:8090") 
public interface StockClient {
	
	 @GetMapping("/stock/getbyid/{id}")
	    StockDTO getById(@PathVariable("id") String id);
	 
	 

}
