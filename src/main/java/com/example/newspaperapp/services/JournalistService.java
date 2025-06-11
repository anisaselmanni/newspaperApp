package com.example.newspaperapp.services;

import com.example.newspaperapp.dtos.journalist.CreateJournalistRequest;
import com.example.newspaperapp.dtos.journalist.JournalistDto;
import com.example.newspaperapp.dtos.journalist.UpdateJournalistRequest;

import java.util.List;

public interface JournalistService {
    List<JournalistDto> findAll();
    JournalistDto findById(Long id);
    JournalistDto create(CreateJournalistRequest request);
    JournalistDto update(long id, UpdateJournalistRequest request);
    void delete(Long id);
}
