package com.folcademy.api.services;

import com.folcademy.api.models.entities.Contact;
import com.folcademy.api.repositories.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

   @Autowired
   private ContactoRepository contactoRepository;

   @Transactional
   public Contact saveContact(Contact auxCnt) {
      return contactoRepository.save(auxCnt);
   }
   @Transactional
   public Contact getContact(String auxId) throws Exception {
      return contactoRepository
         .findById(auxId)
         .orElseThrow(() -> new Exception("DON'T FOUND"));
   }
   @Transactional
   public Contact putContact(Contact aux, String id) throws Exception {
      Optional<Contact> optional = contactoRepository.findById(id);
      if (optional.isEmpty()) throw new Exception("DON'T FOUND");
      else {
         Contact contact = optional.get();
         contact.setName(aux.getName());
         contact.setNumberPhone(aux.getNumberPhone());
         contactoRepository.save(contact);
         return contact;
      }
   }
   @Transactional
   public HttpStatus deleteContact(String auxId) throws Exception {
      if(contactoRepository.existsById(auxId)) {
         contactoRepository.deleteById(auxId);
         return HttpStatus.NO_CONTENT;
      } else throw new Exception("DON'T EXIST");
   }
   @Transactional
   public List<Contact> getAll() {
      return contactoRepository.findAll();
   }
}
