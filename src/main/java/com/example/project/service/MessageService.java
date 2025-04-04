package com.example.project.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.example.project.dto.request.MessageRequestDTO;
import com.example.project.dto.request.NotificationRequestDTO;
import com.example.project.dto.response.FirebaseResponseDTO;
import com.example.project.exception.FirebaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    public FirebaseResponseDTO sendNotification(MessageRequestDTO dto) {
        Notification notification = buildNotification(dto.getNotification());
        Message message = buildMessage(dto.getTopic(), notification);

        try {
            FirebaseMessaging.getInstance().sendAsync(message).get();
            String successMessage = "Notificação enviada com sucesso para o tópico: " + dto.getTopic();
            logger.info(successMessage);
            return new FirebaseResponseDTO(successMessage, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "Erro ao enviar notificação: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new FirebaseException(errorMessage, e);
        }
    }

    private Notification buildNotification(NotificationRequestDTO notificationRequestDTO) {
        return Notification.builder()
                .setTitle(notificationRequestDTO.getTitle())
                .setBody(notificationRequestDTO.getBody())
                .setImage(notificationRequestDTO.getImage())
                .build();
    }

    private Message buildMessage(String topic, Notification notification) {
        return Message.builder()
                .setTopic(topic)
                .setNotification(notification)
                .build();
    }
}
