package com.spring.C14S1SpringJWT.repository;

import com.spring.C14S1SpringJWT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}