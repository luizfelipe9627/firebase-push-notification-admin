package com.example.project.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SubscriptionRequestDTO {
    @NotBlank(message = "O tópico é obrigatório")
    private String topic;
    @NotNull(message = "O token é obrigatório")
    private List<String> tokens;
}
