package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ta.model.User;

@Configurable
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findAll();
}
