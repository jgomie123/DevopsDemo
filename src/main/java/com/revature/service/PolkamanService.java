package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Polkaman;
import com.revature.repository.PolkamanRepository;

@Service
public class PolkamanService {
	@Autowired
	private PolkamanRepository polkamanRepository;
	
	public PolkamanService() {
		
	}
	
	
	@Autowired
	public PolkamanService(PolkamanRepository polkamanRepository){
		this.polkamanRepository = polkamanRepository;
	}
	
	/*By default, Spring uses setter injectino - meaning when it tries to perform depenency injection,
	 * it attempts to call a setter method in which it passes the bean to us
	 * 
	 * Spring is very much about convention over configuration. It expections things to be done in a ver
	 * conventional way. For example, this setter method needs to follow the naming convention for 
	 * setters (set + propertyName)
	 * */
	@Autowired
	public void setPolkamanRepository(PolkamanRepository polkamanRepository) {
		this.polkamanRepository = polkamanRepository;
	}
	
	public List<Polkaman> sortPolkamanByName(){
				
		List<Polkaman> polkamans = this.polkamanRepository.findAll();
		
		return polkamans;
	}
	
	public void save(Polkaman polkaman) {
		this.polkamanRepository.save(polkaman);
	}
	
	public Polkaman findById(int id) {
		return this.polkamanRepository.findById(id);
	}
	
}
