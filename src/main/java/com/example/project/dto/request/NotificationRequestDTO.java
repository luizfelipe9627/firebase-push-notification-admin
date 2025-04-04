package com.example.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class NotificationRequestDTO {
    @JsonProperty("title")
    @NotBlank(message = "O título é obrigatório")
    private String title;

    @JsonProperty("body")
    @NotBlank(message = "O corpo é obrigatório")
    private String body;

    @JsonProperty("image")
    private String image;
}
