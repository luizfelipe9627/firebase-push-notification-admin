package com.example.project.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.example.project.dto.request.SubscriptionRequestDTO;
import com.example.project.dto.response.FirebaseResponseDTO;
import com.example.project.exception.FirebaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TopicService {
    private static final Logger logger = LoggerFactory.getLogger(TopicService.class);

    public FirebaseResponseDTO subscribeToTopic(SubscriptionRequestDTO subscriptionRequestDTO) {
        return processTopicSubscription(subscriptionRequestDTO, true);
    }

    public FirebaseResponseDTO unsubscribeFromTopic(SubscriptionRequestDTO subscriptionRequestDTO) {
        return processTopicSubscription(subscriptionRequestDTO, false);
    }

    private FirebaseResponseDTO processTopicSubscription(SubscriptionRequestDTO subscriptionRequestDTO, boolean isSubscribe) {
        String action = isSubscribe ? "inserir" : "remover";
        String successMessage = isSubscribe ? "inserido com sucesso" : "removido com sucesso";

        subscriptionRequestDTO.getTokens().forEach(token -> {
            try {
                if (isSubscribe) {
                    FirebaseMessaging.getInstance()
                            .subscribeToTopicAsync(Collections.singletonList(token), subscriptionRequestDTO.getTopic()).get();
                } else {
                    FirebaseMessaging.getInstance()
                            .unsubscribeFromTopicAsync(Collections.singletonList(token), subscriptionRequestDTO.getTopic()).get();
                }
                logger.info("Token {} no tópico: {}", successMessage, subscriptionRequestDTO.getTopic());
            } catch (Exception e) {
                String errorMessage = "Erro ao " + action + " o token no tópico: " + subscriptionRequestDTO.getTopic();
                logger.error(errorMessage, e);
                throw new FirebaseException(errorMessage, e);
            }
        });

        return new FirebaseResponseDTO("Token " + successMessage + " no tópico: " + subscriptionRequestDTO.getTopic(), HttpStatus.OK);
    }
}
