package com.andrej.test.listener;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;

import com.andrej.test.entities.OrderEntity;
import com.andrej.test.mail.EmailServiceImpl;

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
