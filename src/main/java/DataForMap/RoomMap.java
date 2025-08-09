package DataForMap;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import DTO.RoomDTO;
import Entity.RoomEntity;


@Mapper(componentModel="spring")
@Component
public interface RoomMap  {
	
	@Mapping(source="userDTO", target="userEntity")
	RoomEntity toEntity(RoomDTO roomDTO);
	@Mapping(target="userDTO", source="userEntity")
	RoomDTO toDTO(RoomEntity userEntity);
	@Mapping(source="userDTO", target="userEntity")
	List<RoomDTO> toDTOList(List<RoomEntity> roomEntity);

	
}
