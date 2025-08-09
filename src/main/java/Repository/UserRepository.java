package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	boolean existsByEmail(String email);
	Optional<UserEntity> findByEmail(String email);
	void deleteByEmail(String email);

	
}
