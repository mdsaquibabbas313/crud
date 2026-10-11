package com.abbas.crud.repo;

import com.abbas.crud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
