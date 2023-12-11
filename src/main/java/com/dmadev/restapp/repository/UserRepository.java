package com.dmadev.restapp.repository;

import com.dmadev.restapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByFirstname(String firstname);
}
