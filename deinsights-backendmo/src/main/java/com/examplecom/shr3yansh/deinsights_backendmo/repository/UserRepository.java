package com.examplecom.shr3yansh.deinsights_backendmo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examplecom.shr3yansh.deinsights_backendmo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}