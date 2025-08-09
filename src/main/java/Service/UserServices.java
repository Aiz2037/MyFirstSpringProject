package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DTO.UserDTO;
import DataForMap.UserMappingOperation;
import Entity.UserEntity;
import Repository.UserRepository;


@Service
public class UserServices {
	
	private final UserMappingOperation userMappingOperation;
	private final UserRepository userRepository;
	
	
	@Autowired
	public UserServices(UserRepository userRepository, UserMappingOperation userMappingOperation) { //constructor injection
		this.userMappingOperation = userMappingOperation;
		this.userRepository=userRepository;		
	}
	
	public List<UserDTO> viewAllUsers(){	
		 List<UserEntity> retrieveAllUsers = userRepository.findAll(); 
		 return userMappingOperation.toDTOList(retrieveAllUsers);
	}
	
	public UserEntity createNewUser(UserDTO userDTO) {
		
		 UserEntity newUserCreated =userRepository.save(userMappingOperation.toEntity(userDTO)); 
		 return newUserCreated;
	
	}
	
	
	@Transactional
	public void deleteuserbyEmail(String email) {
		
		userRepository.deleteByEmail(email);
	}
	
	public UserEntity updateUserEmail(String currentEmail, String newEmail) {
		
		 Optional<UserEntity> targetUser = userRepository.findByEmail(currentEmail);
		 if(targetUser.isPresent()) 
		 { UserEntity userToUpdate = targetUser.get();
		 userToUpdate.setEmail(newEmail); 
		 return userRepository.save(userToUpdate);
		 }
		 else return null;//create error message here
}
}