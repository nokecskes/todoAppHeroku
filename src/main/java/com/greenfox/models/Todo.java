package com.greenfox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Connor on 2017.05.09..
 */
@Entity
@Getter
@Setter
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String title;
  boolean isUrgent;
  boolean isDone;

  public Todo() {
  }

  public Todo(String title) {
    this.title = title;
    isUrgent = false;
    isDone = false;
  }

  public Todo(String title, boolean isUrgent, boolean isDone) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
  }

  @Override
  public String toString() {
    return String.format("Todo{ id: %f, title: %s, isUrgent: %b, isDone %b", id, title, isUrgent,
            isDone);
  }
}
