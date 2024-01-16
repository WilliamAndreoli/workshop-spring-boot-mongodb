package com.williamandreoli.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamandreoli.workshopmongo.domain.User;
import com.williamandreoli.workshopmongo.dto.UserDTO;
import com.williamandreoli.workshopmongo.repository.UserRepository;
import com.williamandreoli.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	//Em caso de querer instânciar um User utilizasse o
	//método fromDTO nessa classe a qual já possui a dependência para o BD
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
