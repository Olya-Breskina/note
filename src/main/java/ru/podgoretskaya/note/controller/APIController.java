package ru.podgoretskaya.note.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.podgoretskaya.note.dto.RecordDTO;
import ru.podgoretskaya.note.service.Ser;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@Validated
@CrossOrigin(maxAge = 3600)
@Tag(name = "заметки")
public class APIController {
    private final Ser service;

    @PostMapping("/save")
    @Operation(summary = "добавление заметки")
    public ResponseEntity<Long> save(@RequestBody @Valid RecordDTO model) {
        return ResponseEntity.ok(service.saveInDB(model));
    }

    @PostMapping("/edit/{id}")
    @Operation(summary = "редактирование заметки по идентификатору (id)")
    public ResponseEntity<RecordDTO> edit(@Valid @RequestBody RecordDTO model, @RequestParam("id") Long id) {
        return new ResponseEntity<>(service.edit(id, model), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "все заметки")
    public ResponseEntity<List<RecordDTO>> guide() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
