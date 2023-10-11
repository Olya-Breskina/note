package ru.podgoretskaya.note.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "records")
public class RecordEntity {
    String topic;
    String message;
    LocalDateTime time;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
