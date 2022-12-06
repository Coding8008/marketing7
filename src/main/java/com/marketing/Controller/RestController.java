package com.marketing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/postman")
public class RestController {

	@Autowired
	private LeadRepository leadR;
	
	@GetMapping
	public List<Lead> getLeads() {
		List<Lead> leads = leadR.findAll();
		return leads;
	}
	@PostMapping
	public void createLeads(@RequestBody Lead lead) {
		leadR.save(lead);
	}
	@PutMapping
	public void updateLeads(@RequestBody Lead lead) {
		leadR.save(lead);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadR.deleteById(id);
		
	}
	//http://localhost:8080/api/postman/leadinfo/id
	@GetMapping("/leadinfo/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Optional<Lead> findById = leadR.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
