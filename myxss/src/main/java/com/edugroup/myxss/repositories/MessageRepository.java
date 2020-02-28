package com.edugroup.myxss.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.myxss.metier.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Integer> {

}
