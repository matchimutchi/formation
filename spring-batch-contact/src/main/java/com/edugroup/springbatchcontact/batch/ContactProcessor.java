package com.edugroup.springbatchcontact.batch;

import org.springframework.batch.item.ItemProcessor;

import com.edugroup.springbatchcontact.metier.Contact;

public class ContactProcessor implements ItemProcessor<Contact, Contact> {

	@Override
	public Contact process(Contact item) throws Exception {
		System.out.println("Processing: " + item);
		return new Contact(item.getNom().toUpperCase(),
							item.getPrenom().trim(),
							item.getEmail().trim());

		
	}

}
