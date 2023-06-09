package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.ParentDto;
import com.example.mydiary.models.Parent;
import com.example.mydiary.repositiries.ParentRepository;
import com.example.mydiary.sevices.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Override
    public List<Parent> getParents() {
        return parentRepository.findAll();
    }

    @Override
    public void addParent(ParentDto parentDto) {
        parentRepository.save(Parent.builder()
                        .firstName(parentDto.getFirstName())
                        .lastName(parentDto.getLastName())
                        .build());
    }

    @Override
    public void updateParent(ParentDto parentDto, Long parentId) {
        Parent parent = parentRepository.findById(parentId).orElseThrow();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parentRepository.save(parent);
    }

    @Override
    public void deleteParent(Long parentId) {
        parentRepository.deleteById(parentId);
    }
}
