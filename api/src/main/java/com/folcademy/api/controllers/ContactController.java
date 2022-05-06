package com.folcademy.api.controllers;

import com.folcademy.api.mapper.ContactMapper;
import com.folcademy.api.models.DTOs.ContactDTO;
import com.folcademy.api.models.entities.Contact;
import com.folcademy.api.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contacto")
public class ContactController {

   @Autowired
   private ContactService contactService;

   //===========Gets===========//
   @GetMapping(path = "get-contact/{id}")
   public ResponseEntity<Contact> getContact(@PathVariable("id") String auxId) throws Exception {
      return ResponseEntity.ok(contactService.getContact(auxId));
   }
   @GetMapping(path = "get-all-contact")
   public ResponseEntity<List<Contact>> getAllContact() {
      return ResponseEntity.ok(contactService.getAll());
   }

   //===========Post===========//
   @PostMapping(path = "add-contact")
   public ContactDTO addContact(@RequestBody Contact auxCnt) {
      return contactService.returnDTO(auxCnt);
   }

   //===========Put===========//
   @PutMapping(path = "put-contact/{id}")
   public ResponseEntity<Contact> putContact(@RequestBody Contact auxCnt, @PathVariable("id") String auxId) throws Exception {
         return ResponseEntity.ok(contactService.putContact(auxCnt,auxId));
   }

   //===========Delete===========//
   @DeleteMapping(path = "delete-contact/{id}")
   public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") String auxId) throws Exception {
      return ResponseEntity.ok(contactService.deleteContact(auxId));
   }
}
