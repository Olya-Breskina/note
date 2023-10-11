package ru.podgoretskaya.note.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.note.dto.RecordDTO;
import ru.podgoretskaya.note.entity.RecordEntity;
import ru.podgoretskaya.note.mapper.RecordMap;
import ru.podgoretskaya.note.repository.RecordRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class RecordService implements Ser {
    private final RecordMap mapper;
    private final RecordRepo repo;

    @Override
    public List<RecordDTO> findAll() {
        List<RecordEntity> all = repo.findAll();
        return all.stream().map(mapper::toDto).collect(Collectors.toList());
    }


    @Override
    public Long saveInDB(RecordDTO dto) {
        log.info("\n>>> сохраниение  данных " + dto.toString() + ">>>\n");
        LocalDateTime dateTime = LocalDateTime.now();
        RecordEntity save = repo.save(mapper.toEntity(dto));
        save.setTime(dateTime);
        return save.getId();
    }

    @Override
    public RecordDTO edit(Long id, RecordDTO dto) {
        log.info("\n>>> редактирование записи по id:  " + id + ">>>\n" + "\n>>> сохраниение  данных " + dto.toString() + ">>>\n");
        RecordEntity entity = repo.findById(id).orElseThrow(NoSuchElementException::new);
        RecordEntity entity1 = mapper.toEntity(dto);
        entity1.setId(entity.getId());
        RecordEntity save = repo.save(entity1);
        return mapper.toDto(save);
    }
}
