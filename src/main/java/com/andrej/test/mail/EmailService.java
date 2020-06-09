package com.andrej.test.mail;

public interface EmailService {
	    void sendMessage(String to,
	                           String subject,
	                           String text);
}
