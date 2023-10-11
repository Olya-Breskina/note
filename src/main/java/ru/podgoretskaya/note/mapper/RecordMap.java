package ru.podgoretskaya.note.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.note.dto.RecordDTO;
import ru.podgoretskaya.note.entity.RecordEntity;

@Component
public class RecordMap implements Mapper<RecordEntity, RecordDTO> {
    @Override
    public RecordEntity toEntity(RecordDTO dto) {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setTopic(dto.getTopic());
        recordEntity.setMessage(dto.getMessage());
        return recordEntity;
    }

    @Override
    public RecordDTO toDto(RecordEntity entity) {
        RecordDTO dto = new RecordDTO();
        dto.setTopic(entity.getTopic());
        dto.setMessage(entity.getMessage());
        return dto;
    }
}
