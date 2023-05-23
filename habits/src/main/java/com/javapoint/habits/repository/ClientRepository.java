package com.javapoint.habits.repository;

import com.javapoint.habits.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    //@Query("SELECT username FROM users WHERE username = username")
    public Client getUserByUsername(@Param("username") String username);

    public Client getById(@Param("id") int id);
}
