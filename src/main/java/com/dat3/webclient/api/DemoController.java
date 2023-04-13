package com.dat3.webclient.api;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("demo")
@RestController
public class DemoController{

  private final int SLEEP_TIME = 1000*3;

  @GetMapping(value = "/random-string-slow")
  public String slowEndpoint() throws InterruptedException {
    Thread.sleep(SLEEP_TIME);
    return RandomStringUtils.randomAlphanumeric(10);
  }




}
