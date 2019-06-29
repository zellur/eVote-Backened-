package com.votingsystem.easyelection.data.repository;

import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(resultSet.getLong("id"));
        userModel.setAddress(resultSet.getString("address"));
        userModel.setCity(resultSet.getString("city"));
        userModel.setFirstName(resultSet.getString("first_name"));
        userModel.setGender(resultSet.getString("gender"));
        userModel.setLastName(resultSet.getString("last_name"));
        userModel.setMobile(resultSet.getString("mobile"));
        return userModel;
    }
}
