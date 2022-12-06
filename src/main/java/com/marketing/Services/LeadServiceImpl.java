package com.marketing.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRep;

	@Override
	public void saveLeadInfo(Lead lead) {
		leadRep.save(lead);
	}

	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRep.findAll();
		return leads;
	}

	@Override
	public void deleteOLead(long id) {
		leadRep.deleteById(id);
		
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRep.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
