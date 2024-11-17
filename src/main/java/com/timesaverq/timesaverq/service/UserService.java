package com.timesaverq.timesaverq.service;

import com.timesaverq.timesaverq.dto.request.UserRequest;
import com.timesaverq.timesaverq.dto.response.UserResponse;
import com.timesaverq.timesaverq.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse create(UserRequest request);
    User create(User user);
    User getById(String id);
    UserResponse getAuthentication();

//    void updatePassword(String id, UserUpdatePasswordRequest request);
}
