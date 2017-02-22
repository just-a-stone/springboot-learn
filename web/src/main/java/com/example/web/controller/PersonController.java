package com.example.web.controller;

import com.example.web.dao.PersonRepository;
import com.example.web.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lupf on 2017/2/22.
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("page")
    public List<Person> page() {
        return personRepository.findAll();
    }

    @RequestMapping("one")
    public Person getOne(){
        return personRepository.findOne(1L);
    }

    @RequestMapping("byAddress")
    public List<Person> query(){
        return personRepository.findByAddress("合肥");
    }
}
