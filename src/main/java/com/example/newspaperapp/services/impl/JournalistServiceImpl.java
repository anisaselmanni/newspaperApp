package com.example.newspaperapp.services.impl;


import com.example.newspaperapp.dtos.journalist.CreateJournalistRequest;
import com.example.newspaperapp.dtos.journalist.JournalistDto;
import com.example.newspaperapp.dtos.journalist.UpdateJournalistRequest;
import com.example.newspaperapp.entities.Journalist;
import com.example.newspaperapp.exceptions.EmailNotChangeableException;
import com.example.newspaperapp.exceptions.JournalistNotFoundException;
import com.example.newspaperapp.mappers.JournalistMapper;
import com.example.newspaperapp.repositories.JournalistRepository;
import com.example.newspaperapp.services.JournalistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalistServiceImpl implements JournalistService {
    private final JournalistRepository repository;
    private final JournalistMapper mapper;

    @Override
    public List<JournalistDto> findAll() {
        return repository.findAll()
                .stream()
                .map(journalist -> new JournalistDto(journalist.getId(), journalist.getFirstName(), journalist.getLastName(), journalist.getPassword(), journalist.getUser().getRole()))
                .toList();
    }

    @Override
    public JournalistDto findById(Long id) {
        return repository.findById(id)
                .map(journalist -> new JournalistDto(journalist.getId(), journalist.getFirstName(), journalist.getLastName(), journalist.getPassword(), journalist.getUser().getRole()))
                .orElseThrow(() -> new JournalistNotFoundException(id));
    }

    @Override
    public JournalistDto create(CreateJournalistRequest request) {

Journalist journalistToCreate = Journalist.builder()
    .user(request.getUser())
    .firstName(request.getFirstName())
    .lastName(request.getLastName())
    .bio(request.getBio())
    .password(request.getPassword())
    .profilePictureURL(request.getProfilePictureURL())
    .joinedAt(Instant.now())
    .build();
        var createdJournalist = repository.save(journalistToCreate);
        return mapper.toDto(createdJournalist);
    }

    @Override
    public JournalistDto update(long id, UpdateJournalistRequest request) {
        var journalistFromDb = repository.findById(id)
                .orElseThrow(() -> new JournalistNotFoundException(id));
        if (!journalistFromDb.getFirstName().equals(request.getFirstName())) {
            throw new EmailNotChangeableException();
        }
        journalistFromDb.setFirstName(request.getFirstName());
        journalistFromDb.setLastName(request.getLastName());
        journalistFromDb.setPassword(request.getPassword());
        var updatedJournalist = repository.save(journalistFromDb);
        return mapper.toDto(updatedJournalist);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new JournalistNotFoundException(id));
        repository.deleteById(id);
    }
}
