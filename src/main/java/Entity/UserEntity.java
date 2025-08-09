package Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User_Table") //if UserTable, h2 database treated as User_Table , better write underscore
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity{ 

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;			//better to use small letters
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="userEntity", cascade = CascadeType.ALL)

	private List<RoomEntity> roomentity = new ArrayList<>();	
	
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
	
	public List<RoomEntity> getRoomentity() {return roomentity;}
	public void setRoomentity(List<RoomEntity> roomentity) {this.roomentity = roomentity;}
	
}
