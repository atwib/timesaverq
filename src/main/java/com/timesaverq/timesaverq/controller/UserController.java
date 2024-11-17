package com.timesaverq.timesaverq.controller;

import com.timesaverq.timesaverq.constant.RequestPath;
import com.timesaverq.timesaverq.constant.ResponseMessage;
import com.timesaverq.timesaverq.dto.request.UserRequest;
import com.timesaverq.timesaverq.dto.response.UserResponse;
import com.timesaverq.timesaverq.service.UserService;
import com.timesaverq.timesaverq.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = RequestPath.API_USER)
@Tag(name = "User Management", description = "API's for User Management, including creating, updating, and deleting users.")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
        UserResponse userResponse = userService.create(request);
        return ResponseUtil.buildResponse(HttpStatus.CREATED, ResponseMessage.USER_SUCCESS_REGISTER, userResponse);
    }
}
