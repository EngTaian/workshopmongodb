package com.taian.worshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taian.worshopmongo.domain.Post;
import com.taian.worshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll(){
		List<Post> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
			
			
}
