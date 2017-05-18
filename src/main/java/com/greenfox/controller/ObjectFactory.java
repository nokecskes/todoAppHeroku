package com.greenfox.controller;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Connor on 2017.05.11..
 */
@Configuration
public class ObjectFactory {

  @Bean
  public ModelAndView getModelAndView() {
    return new ModelAndView();
  }

  @Bean
  public ArrayList<String> getStringArrayList() {return new ArrayList<>();}
}
