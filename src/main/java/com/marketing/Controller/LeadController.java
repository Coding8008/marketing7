package com.marketing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.Services.LeadService;
import com.marketing.dto.LeadData;
import com.marketing.entity.Lead;
import com.marketing.util.EmailServices;


@Controller
public class LeadController {
	
	@Autowired
	private EmailServices semail;

	@Autowired
	private LeadService leadService;
	
	
	@RequestMapping("/lead")
	public String createOneLead() {
		return "create_lead";
		}
	@RequestMapping("/saveInfo")
	public String saveLeadInfo(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile,ModelMap model) {
		Lead lead=new Lead();
		lead.setFirstName(firstName);
		lead.setLastName(lastName);
		lead.setEmail(email);
		lead.setMobile(mobile);
		leadService.saveLeadInfo(lead);
		semail.sendEmail(lead.getEmail(), "Karnataka", "One World Many Statesn/n/Vist Again");
		model.addAttribute("msg", "Data is saved");
		return "create_lead";
		 
	}
	
	@RequestMapping("/listAll")
	public String getLeads(Model model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads );
		System.out.println(leads);
		return "all_leads";
		
	}
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id,Model model) {
		leadService.deleteOLead(id);
		
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "all_leads";
	}
	@RequestMapping("/update")
	public String getOneLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/updateLead")
	public String updateLead(LeadData data,Model model) {
	Lead l = new Lead();
	l.setId(data.getId());
	l.setFirstName(data.getFirstName());
	l.setLastName(data.getLastName());
	l.setEmail(data.getEmail());
	l.setMobile(data.getMobile());
	
	leadService.saveLeadInfo(l);
	
	List<Lead> leads = leadService.getLeads();
	model.addAttribute("leads", leads);
	return "all_leads";
	
	}
}
