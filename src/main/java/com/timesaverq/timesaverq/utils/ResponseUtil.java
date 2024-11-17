package com.timesaverq.timesaverq.utils;

import com.timesaverq.timesaverq.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<CommonResponse<T>> buildResponse(HttpStatus httpStatus, String message, T data){
        CommonResponse<T> response = new CommonResponse<>(httpStatus.value(), message, data);
        return new ResponseEntity<>(response, httpStatus);
    }
}
