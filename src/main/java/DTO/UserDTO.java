package DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;			
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private List<RoomDTO> roomDTO = new ArrayList<>();
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;} 
	
	public String getfirstname() {return firstname;}
	public void setfirstname(String firstname) {this.firstname = firstname;}
	
	public String getlastname() {return lastname;}
	public void setlastname(String lastname) {this.lastname = lastname;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;} 
	
	public String getpassword() {return password;}
	public void setpassword(String password) { this.password = password;}
	
	public List<RoomDTO> getRoomDTO() {return roomDTO;}
	public void setRoomDTO(List<RoomDTO> roomDTO) {this.roomDTO = roomDTO;}
	
}
