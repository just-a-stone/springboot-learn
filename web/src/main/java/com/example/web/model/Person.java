package com.example.web.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lupf on 2017/2/22.
 */
@Entity
@Data
public class Person implements Serializable{

    private static final long serialVersionUID = 7814879340173011708L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

}
