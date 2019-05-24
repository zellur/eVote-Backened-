package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.data.domain.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {

    @Query(value = "select * from voter v where v.election_id = :electionId", nativeQuery = true)
    List<Voter> findVoterListByElectionId(@Param("electionId") String electionId);
}
