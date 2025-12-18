package com.seong.coretime.user.repository;

import com.seong.coretime.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
