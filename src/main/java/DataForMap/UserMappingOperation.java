package DataForMap;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import DTO.UserDTO;
import Entity.UserEntity;

@Mapper(componentModel="spring")
@Component
public interface UserMappingOperation {

	@Mapping(source="roomDTO", target="roomentity")
	UserEntity toEntity(UserDTO userDTO);
	
	@Mapping(target="roomDTO", source="roomentity")
	UserDTO toDTO(UserEntity userEntity);
	
	@Mapping(source="roomDTO", target="roomentity")
	List<UserDTO> toDTOList(List<UserEntity> userEntity);
	

}
