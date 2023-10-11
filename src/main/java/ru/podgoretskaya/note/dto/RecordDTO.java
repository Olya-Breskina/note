package ru.podgoretskaya.note.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "заметки")
public class RecordDTO {
    @Schema(description = "тема")
    String topic;
    @Schema(description = "сообщение")
    String message;
}
