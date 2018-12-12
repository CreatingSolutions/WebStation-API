package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webstationapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailAddress(String emailAddress);

}
