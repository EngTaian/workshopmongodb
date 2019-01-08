package com.taian.worshopmongo.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taian.worshopmongo.domain.Post;
import com.taian.worshopmongo.repository.PostRepository;
import com.taian.worshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		List<Post> obj = repo.findAll();
		return obj;
	}

	public Post findByid(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String title){
		return repo.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> findByTitleJSon(String title){
		return repo.findByTitle(title);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getDate() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
