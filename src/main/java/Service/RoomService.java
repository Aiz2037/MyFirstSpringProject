package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.RoomDTO;
import DataForMap.RoomMap;
import Entity.RoomEntity;
import Entity.UserEntity;
import Repository.RoomRepository;
import Repository.UserRepository;

@Service
public class RoomService {

	private final RoomMap roomMap;
	private final RoomRepository roomRepository;
	private final UserRepository userRepository; 

	@Autowired
	public RoomService(RoomRepository roomRepository, RoomMap roomMap, UserRepository userRepository) {
		this.roomMap = roomMap;
		this.roomRepository=roomRepository;
		this.userRepository = userRepository;
	}
	
	public RoomEntity bookRoom(RoomDTO roomDTO) {
		List<RoomEntity> activeRooms = roomRepository.findActiveRooms();

		for(RoomEntity activeRoom:activeRooms) {

			if((activeRoom.getTimeslot().equals(roomDTO.getTimeslot()) && activeRoom.getRoom().equals(roomDTO.getRoom())))
			{
				return null; //create error message here
			}
		} 
		return roomRepository.save(roomMap.toEntity(roomDTO));
	
	}
	
	public RoomDTO assignedUserToRoom(Long bookingroomid,Long userid){ //map UserEntity into RoomEntity 
		Optional<RoomEntity> roomToAssign=roomRepository.findById(bookingroomid);
		Optional<UserEntity> userToAssign=userRepository.findById(userid);
		RoomEntity roomToUpdate=roomToAssign.get();
		UserEntity selectedUser = userToAssign.get();
		roomToUpdate.setUserEntity(selectedUser);
		roomRepository.save(roomToUpdate); //assignment dekat entity
		return roomMap.toDTO(roomToUpdate); //return DTO type
		
	}
	
	public List<RoomDTO> viewAllBookedRooms(){
		List<RoomEntity> roomEntity = roomRepository.findAll();
		return roomMap.toDTOList(roomEntity);

	}
}
