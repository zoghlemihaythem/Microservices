package com.esprit.secondapp.controllers;

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

import com.esprit.secondapp.entities.Stock;
import com.esprit.secondapp.repository.StockRepository;
import com.esprit.secondapp.services.IStockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	private IStockService iStockService;
	
	 @GetMapping("/getAll")
	  public List<Stock> getAllTutorials() {
		 return iStockService.getAllStock();
	    
	  }
	 
	 
	 @PostMapping("/save")
	 public Stock save(@RequestBody Stock stock) {
		 return iStockService.addStock(stock);
		 
	    
	  }
	 @DeleteMapping("/delete/{id}")
     public void supprimer(@PathVariable("id") String id){
		 iStockService.deleteStockById(id);

     }
     @GetMapping("/getbyid/{id}")
    public Stock GetById(@PathVariable("id") String id){
        return iStockService.getStockById(id);
     }
     
     
     @PatchMapping("/update/{id}")
     public Stock patchUpdateStock(@PathVariable String id, @RequestBody Map<String, Object> updates) {
         return iStockService.updateStock(id,  updates);

     }

}
