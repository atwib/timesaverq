package com.timesaverq.timesaverq.service;

import com.timesaverq.timesaverq.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface JwtService {
    String generateAccessToken(User user);
    String getUserId(String token);
    String extractTokenFromRequest(HttpServletRequest request);
    void blacklistAccessToken(String bearerToken);
    boolean isTokenBlacklisted(String token);
}
