package gft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.user.ConsultUserDTO;
import gft.dto.user.RegisterUserDTO;
import gft.dto.user.UserMapper;
import gft.entities.UserEntity;
import gft.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("v1/users")
public class UserController {
	
	private final UserDetailsServiceImpl userService;
	
	public UserController(UserDetailsServiceImpl userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<ConsultUserDTO> saveUser(@RequestBody RegisterUserDTO dto){
		
		UserEntity userEntity = userService.saveUser(UserMapper.fromDTO(dto));
		return ResponseEntity.ok(UserMapper.fromEntity(userEntity));
	}

}
