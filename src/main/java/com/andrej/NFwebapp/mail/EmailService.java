package com.andrej.NFwebapp.mail;

public interface EmailService {
	    void sendMessage(String to,
	                           String subject,
	                           String text);
}
