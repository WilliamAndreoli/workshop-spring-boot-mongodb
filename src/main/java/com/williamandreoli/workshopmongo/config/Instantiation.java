package com.williamandreoli.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.williamandreoli.workshopmongo.domain.Post;
import com.williamandreoli.workshopmongo.domain.User;
import com.williamandreoli.workshopmongo.dto.AuthorDTO;
import com.williamandreoli.workshopmongo.repository.PostRepository;
import com.williamandreoli.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat idf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, (Date) idf.parse("21/03/2018"), "Partiu Viajar", "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, (Date) idf.parse("05/06/2022"), "Bom Dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}
	
	
	
}
