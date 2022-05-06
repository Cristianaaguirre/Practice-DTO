package com.folcademy.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludos")
public class SaludosControllers {
   
   @GetMapping("/hello")
   public ResponseEntity<String> hello() {
      return ResponseEntity.ok("Hola! Mi nombre es Cristian y esta es mi primera API");
   }

   @PostMapping("/good-bye")
   public ResponseEntity<String> goodBye() {
      return ResponseEntity.ok("Hasta luego!");
   }
}
