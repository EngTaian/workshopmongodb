package com.taian.worshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taian.worshopmongo.domain.User;
import com.taian.worshopmongo.dto.UserDTO;
import com.taian.worshopmongo.repository.UserRepository;
import com.taian.worshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
		
	}
	
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getEmail(), obj.getName());
	}
}
