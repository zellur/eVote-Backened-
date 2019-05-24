package com.votingsystem.easyelection.service;

import com.votingsystem.easyelection.exception.BadRequestException;
import com.votingsystem.easyelection.web.model.ElectionModel;

import java.util.Set;

public interface ElectionService {
    public ElectionModel saveElection(ElectionModel electionModel) throws BadRequestException;

    public Set<ElectionModel> getElectionList() throws BadRequestException;

    public void deleteElection(Long id) throws BadRequestException;
}
