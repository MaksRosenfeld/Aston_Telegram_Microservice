package com.rosenfeld.repository;

import com.rosenfeld.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
