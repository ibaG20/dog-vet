package gft.dto.user;

import java.util.UUID;

public class ConsultUserDTO {
	
	private UUID userId;
	private String userName;
	private String password;
	
	//---------------------------------------------
	
	public ConsultUserDTO() {
	}
	public ConsultUserDTO(UUID userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	//---------------------------------------------
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
