package com.incb.store_content_manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseBody {
    private int error_code;
    private HttpStatusCode http_response;
    private String timestamp;
    private String error_message;
}
