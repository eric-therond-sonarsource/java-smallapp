package com.sonarsource.rspec5145;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import org.owasp.encoder.Encode;

@Controller
public class Compliantslf4j5145 {

  private static final Logger LOGGER = LoggerFactory.getLogger(Compliantslf4j5145.class);

  // localhost:8080/s5145/slf4j/compliant/javaencoder?message=attack1%0D%0Aattack2

  @RequestMapping(value = "/s5145/slf4j/compliant/javaencoder", method = {RequestMethod.GET})
  public String testslf4j(@RequestParam("message") String message) {

    LOGGER.info("log this: " + Encode.forJava(message)); // Compliant (s5145)

    return "thymeleaf/welcome";
  }

  // localhost:8080/s5145/slf4j/compliant/javaencoderformat?message=attack1%0D%0Aattack2

  @RequestMapping(value = "/s5145/slf4j/compliant/javaencoderformat", method = {RequestMethod.GET})
  public String testslf4jformatted(@RequestParam("message") String message) {

    String formattedMessage = String.format("@Android error: %s.", Encode.forJava(message));

    LOGGER.info(formattedMessage); // Compliant (s5145)

    return "thymeleaf/welcome";
  }
}
