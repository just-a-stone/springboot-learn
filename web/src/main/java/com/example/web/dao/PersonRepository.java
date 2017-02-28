package com.example.web.dao;

import com.example.web.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lupf on 2017/2/22.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p.name from Person p where p.address = :address")
    List<Person> findByAddress(@Param("address") String address);

    List<Person> findByNameAndAddress(String name, String address);
}
