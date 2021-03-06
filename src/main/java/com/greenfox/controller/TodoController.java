package com.greenfox.controller;

import com.greenfox.models.Todo;
import com.greenfox.repository.TodoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Connor on 2017.05.09..
 */
@Controller
public class TodoController {

  @Autowired
  TodoRepository todoRepository;

  @Autowired
  ModelAndView m;

  @Autowired
  ArrayList<String> userNames;

  @GetMapping("/")
  public ModelAndView mainPage() {
    m.addObject("userNames", userNames);
    m.setViewName("index");
    return m;
  }

  @GetMapping("/list")
  public ModelAndView listAllTodos() {
    m.addObject("todos", todoRepository.findAll());
    m.setViewName("alltodos");
    return m;
  }

  @GetMapping("checkTodos")
  public ModelAndView list(@RequestParam String filterBy) {
    if (filterBy.equals("not done")) {
      m.addObject("todos", todoRepository.findByIsDoneEquals(false));
    } else if (filterBy.equals("urgent")) {
      m.addObject("todos", todoRepository.findByIsUrgentEquals(false));
    }
    m.setViewName("alltodos");
    return m;
  }

  /*public ModelAndView list(@RequestParam(value = "isActive", required = false) String isActive) {
    if (isActive == null) {
      m.addObject("todos", todoRepository.findAll());
    } else if (isActive.equals("true")) {
      m.addObject("todos", todoRepository.findByIsDoneEquals(false));
    } else if (isActive.equals("false")) {
      m.addObject("todos", todoRepository.findByIsDoneEquals(true));
    }
    m.setViewName("alltodos");
    return m;
  }*/

  @GetMapping(value = "/add")
  public ModelAndView add() {
    m.addObject("todo", new Todo());
    m.setViewName("add");
    return m;
  }

  @PostMapping("/adding")
  public String adding(Todo todo) {
    userNames.add(todo.getName());
    todoRepository.save(todo);
    return "redirect:/";
  }

}


