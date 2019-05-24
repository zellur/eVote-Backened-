package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findByEmailOrMobile(String email, String mobile);

    Optional<User>findByEmail(String email);

    Optional<User>findByMobile(String mobile);

    Boolean existsByEmail(String email);

    Boolean existsByMobile(String mobile);

    @Query("from User u where u.email = :email or u.mobile = :mobile")
    User findUserByEmailOrMobile(@Param(value = "email") String email, @Param(value = "mobile") String mobile);
}
