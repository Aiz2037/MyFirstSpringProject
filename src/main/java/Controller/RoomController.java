package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.RoomDTO;
import Entity.RoomEntity;
import Service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	
	
	private final RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService=roomService;
	}
	
	@GetMapping("/viewAllBookedRooms")
	public List<RoomDTO> viewAllBookedRooms(){
		return roomService.viewAllBookedRooms();
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<RoomEntity> addRoom(@RequestBody RoomDTO roomDTO){ //change to DTO
		RoomEntity addedRoom = roomService.bookRoom(roomDTO);
		return new ResponseEntity<>(addedRoom,HttpStatus.OK);
	}
	
	@PutMapping("/assigned/{bookingroomid}/{userid}")
	public RoomDTO assignedUserToRoom(@PathVariable Long bookingroomid, @PathVariable Long userid) {	//change to DTO
		return roomService.assignedUserToRoom(bookingroomid, userid);
	}
	

}
