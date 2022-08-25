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

import com.cl.food_app.dto.Admin;
import com.cl.food_app.util.ResponseStructure;
import com.cl.food_app.dao.AdminDao;
import com.cl.food_app.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	AdminDao adminDao;
	
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin,@RequestParam int id){
		return adminService.updateAdmin(admin,id);
	
}
	
	
	@GetMapping("/getadminbyid/{id}")
	public ResponseEntity<ResponseStructure<Admin >>getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}
	
	@GetMapping("/findalladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>>findAllAdmin(){
		return adminService.findAllAdmin();	
	}
	
}
