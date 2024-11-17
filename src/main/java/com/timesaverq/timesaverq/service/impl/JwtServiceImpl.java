package com.timesaverq.timesaverq.service.impl;

import com.timesaverq.timesaverq.entity.User;
import com.timesaverq.timesaverq.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    @Override
    public String generateAccessToken(User user) {
        return "";
    }

    @Override
    public String getUserId(String token) {
        return "";
    }

    @Override
    public String extractTokenFromRequest(HttpServletRequest request) {
        return "";
    }

    @Override
    public void blacklistAccessToken(String bearerToken) {

    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return false;
    }
}
