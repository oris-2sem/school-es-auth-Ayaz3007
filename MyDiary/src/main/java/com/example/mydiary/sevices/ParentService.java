package com.example.mydiary.sevices;

import com.example.mydiary.dto.ParentDto;
import com.example.mydiary.models.Parent;

import java.util.List;

public interface ParentService{
    List<Parent> getParents();

    void addParent(ParentDto parentDto);

    void updateParent(ParentDto parentDto, Long parentId);

    void deleteParent(Long parentId);
}
