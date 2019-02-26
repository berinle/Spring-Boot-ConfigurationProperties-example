package com.t3.spring.boot;

import com.t3.spring.boot.config.AppProperties;
import com.t3.spring.boot.config.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class InspectController {
  @Autowired
  private AppProperties appProperties;
  @Autowired private GlobalProperties globalProperties;

  @GetMapping("/inspect")
  public ResponseEntity<?> inspect() {
    HashMap<Object, Object> map = new HashMap<>();
    map.put("app", appProperties);
    map.put("global", globalProperties);
    return ok(map);
  }

  @GetMapping("/ping")
  public String pong() {
    return "pong";
  }
}
