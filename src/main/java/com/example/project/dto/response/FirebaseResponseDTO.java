package com.example.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class FirebaseResponseDTO {
    private String message;
    private HttpStatus status;
}
