package com.folcademy.api.repositories;

import com.folcademy.api.models.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contact, String> {
}