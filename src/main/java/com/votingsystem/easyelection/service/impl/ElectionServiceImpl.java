package com.votingsystem.easyelection.service.impl;

import com.votingsystem.easyelection.data.domain.Election;
import com.votingsystem.easyelection.data.domain.User;
import com.votingsystem.easyelection.data.repository.UserRepository;
import com.votingsystem.easyelection.exception.BadRequestException;
import com.votingsystem.easyelection.security.CurrentUser.SecurityManager;
import com.votingsystem.easyelection.service.ElectionService;
import com.votingsystem.easyelection.web.model.ElectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("electionService")
public class ElectionServiceImpl implements ElectionService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public ElectionModel saveElection(ElectionModel electionModel) throws BadRequestException {
        Long id = SecurityManager.getCurrentUserId();
        if(id == null) throw new BadRequestException("User not logged in");
        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        user.getElections().add(new Election(electionModel));
        userRepository.saveAndFlush(user);
        return electionModel;
    }

    @Override
    public Set<ElectionModel> getElectionList() throws BadRequestException {
        if(SecurityManager.getCurrentUserId() == null) throw new BadRequestException("User not logged in");
        User user = userRepository.getOne(SecurityManager.getCurrentUserId());
        return convertToModels(user.getElections());
    }

    @Override
    public void deleteElection(Long id) throws BadRequestException {
        if(SecurityManager.getCurrentUserId() == null) throw new BadRequestException("User not logged in");
        User user = userRepository.getOne(SecurityManager.getCurrentUserId());
        userRepository.delete(user);
    }

    public Set<ElectionModel> convertToModels(Set<Election> elections) {
        Set<ElectionModel> models = new HashSet<>();
        elections.forEach(i -> models.add(new ElectionModel(i)));
        return models;
    }
}
