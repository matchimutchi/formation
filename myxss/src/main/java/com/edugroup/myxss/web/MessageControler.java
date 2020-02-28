package com.edugroup.myxss.web;



import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.myxss.metier.Message;
import com.edugroup.myxss.repositories.MessageRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageControler {

	@Autowired
	private MessageRepository  messageRepository;
	
	@GetMapping
	public Iterable<Message> findAll(){
		return messageRepository.findAll();
	}
	
	@PostMapping
	public Message save(@RequestParam("titre") String titre,@RequestParam("corps") String corps) {
		PolicyFactory policy = new HtmlPolicyBuilder()
				.allowElements("b", "i","div")
				.allowAttributes("class").onElements("div","i").toFactory();
		
		return messageRepository.save(new Message(0,titre,policy.sanitize(corps)));
	}
	
	
}
