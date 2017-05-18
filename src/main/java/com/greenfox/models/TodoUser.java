package com.greenfox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Connor on 2017.05.18..
 */
@Entity
@Getter
@Setter
public class TodoUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String name;
  int age;

  public TodoUser() {
  }

  public TodoUser(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
