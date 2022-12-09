package gft.services;

import org.springframework.stereotype.Service;

import gft.entities.UserEntity;
import gft.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserEntity saveUser(UserEntity userEntity) {
		
		return userRepository.save(userEntity);
	}

}
