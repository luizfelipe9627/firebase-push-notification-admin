package com.example.project.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MessageRequestDTO {
    @NotBlank(message = "O tópico é obrigatório")
    private String topic;
    @Valid
    private NotificationRequestDTO notification;
}
