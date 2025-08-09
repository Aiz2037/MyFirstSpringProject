package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Entity.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Long>
{
	@Query(value="Select * From Room_Table where status='Active'", nativeQuery = true)
	List<RoomEntity> findActiveRooms();

}

