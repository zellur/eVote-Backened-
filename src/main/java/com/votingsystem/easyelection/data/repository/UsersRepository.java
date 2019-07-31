package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserModel>getUsers() {
        List<UserModel> models = null;
        String query = "select * from user";
        try {
            models = jdbcTemplate.query(query, new UserMapper());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return models;
    }
}
