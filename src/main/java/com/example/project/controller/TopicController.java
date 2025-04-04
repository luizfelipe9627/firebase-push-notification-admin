package com.example.project.controller;

import com.example.project.dto.request.SubscriptionRequestDTO;
import com.example.project.dto.response.FirebaseResponseDTO;
import com.example.project.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<FirebaseResponseDTO> subscribeToTopic(@RequestBody @Valid SubscriptionRequestDTO subscriptionRequestDTO) {
        FirebaseResponseDTO response = topicService.subscribeToTopic(subscriptionRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<FirebaseResponseDTO> unsubscribeFromTopic(@RequestBody @Valid SubscriptionRequestDTO subscriptionRequestDTO) {
        FirebaseResponseDTO response = topicService.unsubscribeFromTopic(subscriptionRequestDTO);
        return ResponseEntity.ok(response);
    }
}
