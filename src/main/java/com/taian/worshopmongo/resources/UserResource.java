package com.taian.worshopmongo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taian.worshopmongo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")	
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
}
