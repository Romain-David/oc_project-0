package com.lambazon.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GetMapping("/products")
	public String products	(Model model) {
		model.addAttribute("prods", productService.products());
		model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount());
		return "products";
	}
	
	@GetMapping("/products/{id}/details")
	public String product	(@PathVariable Integer id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}

	/*
		This method returns the total value of all inventory
	 	@return -> the total value of all inventory
	Note :
	Comment Affiliation TODO Auto-generated method stub.
	Indeed the bugue concerning the total value of the stock displayed on the page produced at 123456,78 has already been corrected.
	The calculation has already implemented in the method calculateTotalInventoryAmount of ProductController
	 */
	private double calculateTotalInventoryAmount() {

		double totalInventoryAmount = 0.0;
		for (Product p : productService.products()) {
			totalInventoryAmount+=p.getInventoryPrice();
		}
		
		return totalInventoryAmount;
		
		
	}
}
