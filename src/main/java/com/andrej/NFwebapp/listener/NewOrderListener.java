package com.andrej.NFwebapp.listener;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;

import com.andrej.NFwebapp.entities.OrderEntity;
import com.andrej.NFwebapp.mail.EmailServiceImpl;

public class NewOrderListener {
	@Autowired
	EmailServiceImpl mailService;
	
	@PostPersist
	public void methodInvokedAfterPersist(OrderEntity oe) {
		//EmailServiceImpl mailService = new EmailServiceImpl();
		String text = "Prispelo je novo naročilo od uporabnika: " + oe.getUsername();
		mailService.sendMessage("andrej.sovic@gmail.com", "NF: Novo naročilo", text);
	}
}
