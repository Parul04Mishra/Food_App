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

import com.cl.food_app.dao.BranchDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.service.BranchService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class BranchController {
	
	@Autowired
	BranchService branchService;
	@Autowired
	BranchDao branchDao;
	
	
	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@RequestParam int id){
		return branchService.updateBranch(branch,id);
		

}
	
	@GetMapping("/getbranchbyid/{id}")
	public ResponseEntity<ResponseStructure<Branch>>getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}
	
	@DeleteMapping("/deletebranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id) {
		return branchService.deleteBranch(id);
	}
	
	@GetMapping("/findallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>>findAllBranch(){
		return branchService.findAllBranch();	
	}
}
