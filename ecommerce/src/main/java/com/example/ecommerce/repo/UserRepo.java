package com.example.ecommerce.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.UserProjection;



@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer>{

	@Query("SELECT u.id AS id, u.username AS userName, u.role AS role ,u.name AS name,u.email AS email FROM MyUser u")
	List<UserProjection> findUserDetails();

	public Optional<MyUser> findByUsername(String username);
}
