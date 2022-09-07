package com.example.demofinaltemp.repository;

import com.example.demofinaltemp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLoginId(final String loginId);
    User findByLoginId(final String loginId);
}
