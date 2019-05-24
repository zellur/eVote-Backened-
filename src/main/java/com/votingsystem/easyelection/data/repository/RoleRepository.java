package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.data.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role>findByRoleName(String roleName);

    @Query("from Role r where r.roleName = :roleName")
    Role findByRole(@Param(value = "roleName") String roleName);
}
