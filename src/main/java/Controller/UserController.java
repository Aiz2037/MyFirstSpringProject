package Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.UserDTO;
import Entity.UserEntity;
import Repository.UserRepository;
import Service.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserServices userServices;
	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserServices userServices, UserRepository userRepository){
		this.userServices = userServices;
		this.userRepository = userRepository;
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<UserDTO>> viewAllUsers(){
		List<UserDTO> allUsers= userServices.viewAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	@PostMapping("/addNewUser")
	public ResponseEntity<UserEntity> createNewUser(@RequestBody UserDTO userDTO)
	{
		if(userRepository.existsByEmail(userDTO.getEmail()))
		{	
			return new ResponseEntity<>(HttpStatus.LOCKED);   //semak balik
		}
		UserEntity newUserCreated = userServices.createNewUser(userDTO);
		return new ResponseEntity<>(newUserCreated, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByEmail")
	public ResponseEntity<?> deleteByEmail(@RequestParam String email)
	{
		userServices.deleteuserbyEmail(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserEntity> updateUserEmail(@RequestParam String currentEmail, @RequestParam String newEmail){
		UserEntity updatedUserEmail = userServices.updateUserEmail(currentEmail, newEmail);
		return new ResponseEntity<>(updatedUserEmail,HttpStatus.OK);
	}
}
