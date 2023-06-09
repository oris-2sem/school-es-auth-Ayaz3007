package com.example.mydiary.controllers;

import com.example.mydiary.dto.ParentDto;
import com.example.mydiary.models.Parent;
import com.example.mydiary.sevices.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<List<Parent>> getAll() {
        return ResponseEntity.ok(parentService.getParents());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ParentDto parentDto) {
        parentService.addParent(parentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{parent-id}")
    public ResponseEntity<?> update(ParentDto parentDto, @PathVariable("parent-id")Long parentId) {
        parentService.updateParent(parentDto, parentId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{parent-id}")
    public ResponseEntity<?> delete(@PathVariable("parent-id")Long parentId) {
        parentService.deleteParent(parentId);
        return ResponseEntity.accepted().build();
    }
}
