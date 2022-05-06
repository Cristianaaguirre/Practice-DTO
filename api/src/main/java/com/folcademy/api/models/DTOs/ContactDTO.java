package com.folcademy.api.models.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDTO {
   String id;
   String msj;

   public ContactDTO(String id) {
      this.id = id;
      this.msj = "El contacto ha sido guardado exitosamente";
   }
}
