package com.example.project.controller;

import com.example.project.dto.request.MessageRequestDTO;
import com.example.project.dto.response.FirebaseResponseDTO;
import com.example.project.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<FirebaseResponseDTO> sendNotification(@RequestBody @Valid MessageRequestDTO dto) {
        FirebaseResponseDTO response = messageService.sendNotification(dto);
        return ResponseEntity.ok(response);
    }
}
