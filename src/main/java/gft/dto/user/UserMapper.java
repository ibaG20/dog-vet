package gft.dto.user;

import gft.entities.UserEntity;

public class UserMapper {
	
	public static UserEntity fromDTO (RegisterUserDTO dto) {
		return new UserEntity(null, dto.getUserName(), dto.getPassword());
	}
	
	public static ConsultUserDTO fromEntity(UserEntity userEntity) {
		return new ConsultUserDTO(userEntity.getUserId(), userEntity.getUserName(),
				userEntity.getPassword());
	}

}
