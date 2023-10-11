package ru.podgoretskaya.note.service;

import ru.podgoretskaya.note.dto.RecordDTO;

import java.util.List;

public interface Ser {
    List<RecordDTO> findAll();

    Long saveInDB(RecordDTO dto);

    RecordDTO edit(Long id, RecordDTO dto);
}
