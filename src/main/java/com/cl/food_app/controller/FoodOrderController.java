package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dao.FoodOrderDao;
import com.cl.food_app.dto.FoodOrder;

import com.cl.food_app.service.FoodOrderService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class FoodOrderController {
	
	@Autowired
	FoodOrderService foodOrderService;
	@Autowired
	FoodOrderDao foodOrderDao;
	
	
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id){
		return foodOrderService.updateFoodOrder(foodOrder,id);
	
}
	
	
	@GetMapping("/getFoodOrderbyid/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder >>getFoodOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	
	@DeleteMapping("/deleteFoodOrder/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@PathVariable int id) {
		return foodOrderService.deleteFoodOrder(id);
	}
	
	@GetMapping("/findallFoodOrder")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>findAllFoodOrder(){
		return foodOrderService.findAllFoodOrder();	
	}

}


