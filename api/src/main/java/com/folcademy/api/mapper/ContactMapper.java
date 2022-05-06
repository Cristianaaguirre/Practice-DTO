package com.folcademy.api.mapper;

import com.folcademy.api.models.DTOs.ContactDTO;
import com.folcademy.api.models.entities.Contact;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "contactMapper")
public class ContactMapper {

   public ContactDTO entityToDTO(Contact auxCnt) {
      return Optional
         .ofNullable(auxCnt)
         .map(
            ent -> new ContactDTO(ent.getId())
         )
         .orElse(new ContactDTO());
   }

   public Contact dtoToEntity(@NotNull ContactDTO auxDto) {
      Contact contact = new Contact();
      contact.setId(auxDto.getId());
      return contact;
   }
}
