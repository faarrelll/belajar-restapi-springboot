package com.enigm.belajar_restapi.repository;

import com.enigm.belajar_restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
