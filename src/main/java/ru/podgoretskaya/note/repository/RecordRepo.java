package ru.podgoretskaya.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.note.entity.RecordEntity;

public interface RecordRepo extends JpaRepository<RecordEntity, Long> {

}
