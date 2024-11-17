package com.timesaverq.timesaverq.service.impl;

import com.timesaverq.timesaverq.constant.ResponseMessage;
import com.timesaverq.timesaverq.constant.TableName;
import com.timesaverq.timesaverq.constant.UserRole;
import com.timesaverq.timesaverq.dto.request.UserRequest;
import com.timesaverq.timesaverq.dto.response.UserResponse;
import com.timesaverq.timesaverq.entity.User;
import com.timesaverq.timesaverq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserResponse create(UserRequest request) {
        try{
            UserRole userRole = UserRole.findByDescription(request.getRole());
            if(userRole == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ResponseMessage.USER_ERROR_ROLE_NOT_FOUND);

            String sql = String.format("INSERT INTO %s (id, username, password, name, phone_number, role ) VALUES (?, ?, ?, ?, ?, ?)", TableName.TBL_USER);
            String generatedId = UUID.randomUUID().toString();
            String passEncoded = new BCryptPasswordEncoder().encode(request.getPassword());

            int rowsAffected = jdbcTemplate.update(sql,
                    generatedId,
                    request.getUsername(),
                    passEncoded,
                    request.getName(),
                    request.getPhoneNumber(),
                    request.getRole()
            );

            if (rowsAffected == 0) {
                throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, ResponseMessage.USER_ERROR_FAILED_TO_REGISTER);
            }

            User user = User.builder()
                    .id(generatedId)
                    .username(request.getUsername())
                    .password(passEncoded)
                    .name(request.getName())
                    .phoneNumber(request.getPhoneNumber())
                    .role(UserRole.findByDescription(request.getRole()))
                    .build();

            return toUserResponse(user);
        }catch(DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ResponseMessage.USER_ERROR_USERNAME_EXIST);
        }
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }


    @Override
    public UserResponse getAuthentication() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().name())
                .build();
    }
}
