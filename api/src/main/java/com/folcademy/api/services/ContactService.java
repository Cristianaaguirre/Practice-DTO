package com.folcademy.api.services;

import com.folcademy.api.mapper.ContactMapper;
import com.folcademy.api.models.DTOs.ContactDTO;
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
   @Autowired
   private ContactMapper contactMapper;

   @Transactional
   public ContactDTO returnDTO(Contact auxCnt) {
      return contactMapper.entityToDTO(contactoRepository.save(auxCnt));
   }
   @Transactional
   public Contact getContact(String auxId) throws Exception {
      return contactoRepository
         .findById(auxId)
         .orElseThrow(() -> new Exception("DON'T FOUND"));
   }
   @Transactional
   public Contact putContact(Contact aux, String id) throws Exception {
      Contact contact = getContact(id);
      contact.setName(aux.getName());
      contact.setNumberPhone(aux.getNumberPhone());
      return contactoRepository.save(contact);
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
