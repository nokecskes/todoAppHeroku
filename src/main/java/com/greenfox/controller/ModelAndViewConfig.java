package com.greenfox.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Connor on 2017.05.11..
 */
@Configuration
public class ModelAndViewConfig {

  @Bean
  public ModelAndView getModelAndView() {
    return new ModelAndView();
  }
}
