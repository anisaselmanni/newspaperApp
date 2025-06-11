package com.example.newspaperapp.repositories;

import com.example.newspaperapp.entities.Journalist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalistRepository extends JpaRepository<Journalist,Long> {
}
