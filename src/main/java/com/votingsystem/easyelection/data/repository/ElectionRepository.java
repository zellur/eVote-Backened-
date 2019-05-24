package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.data.domain.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {

    @Query(value = "select * from election e where e.user_id = :userId", nativeQuery = true)
    List<Election> findElectionByUser(@Param("userId") String userId);
}
