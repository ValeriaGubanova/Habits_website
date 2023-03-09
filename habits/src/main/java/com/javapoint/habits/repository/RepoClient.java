package com.javapoint.habits.repository;

import com.javapoint.habits.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoClient extends JpaRepository<Client, Integer> {
}
