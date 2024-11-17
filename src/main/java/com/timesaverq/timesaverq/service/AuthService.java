package com.timesaverq.timesaverq.service;


import com.timesaverq.timesaverq.dto.request.AuthRequest;
import com.timesaverq.timesaverq.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    AuthResponse refreshToken(String token);
    void logout(String accessToken);
    int generateTokenExpireInSecond();
}
