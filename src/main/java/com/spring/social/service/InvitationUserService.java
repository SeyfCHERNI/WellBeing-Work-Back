package com.spring.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.spring.social.dao.InvitationRepository;
import com.spring.social.dao.InvitationUserRep;
import com.spring.social.dao.UserRepository;
import com.spring.social.model.Invitation;
import com.spring.social.model.InvitationUser;




@Service
public class InvitationUserService implements IinvitationUser  {
	@Autowired
	InvitationUserRep invitationUserRep ;
	
	@Autowired
	UserRepository userRepository ;
	
	

	@Autowired 
	InvitationService invv;
	@Autowired
	InvitationRepository inr;


	@Value("spring.mail.username")
	private String from;

	@Value("spring.mail.password")
	private String password;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String stat(String MetierEmploye) {
		
		List<Invitation> lm = invv.retrieveAllInvitations();
		
		float i = 0 ;
		for (Invitation invitation : lm) {
			
			if (invitation.getMetier_employe().toUpperCase().equals(MetierEmploye.toUpperCase()))
				
				i=i+1;
		}
		float percent = (i/lm.size())*100;
		
		return "Pourcentage de cette Metier: "+MetierEmploye+" est égale a : "+percent;		
		

	}


	@Override
	public List<Invitation> allEmployeAjouter() {
		// TODO Auto-generated method stub
		return  (List<Invitation>) inr.findAll();
	}


	


	@Override
	public List<InvitationUser> allInvitationAffecter() {
		// TODO Auto-generated method stub
		return invitationUserRep.findAll();
	}


	@Override
	public InvitationUser AffecterInvitation(int idU) {
		// TODO Auto-generated method stub
		return null;
	}



}
