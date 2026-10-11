package com.abbas.crud.controller;

import com.abbas.crud.entity.Person;
import com.abbas.crud.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/app/v1")
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    @PostMapping(value = "/addPerson")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person person1 = personRepo.save(person);
        return ResponseEntity.ok(person1);
    }

    @GetMapping(value = "/fetchAll")
    public List<Person> getAllPerson(){
        return personRepo.findAll();
    }

    @GetMapping(value = "/fetchById/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @PutMapping(value = "/updateById/{id}")
    public Person updatePerson(@PathVariable Long id , @RequestBody Person updatedData){
        Person existingData = personRepo.findById(id).orElse(null);
        if(Objects.nonNull(existingData)) {
            // update logic
            existingData.setName(updatedData.getName());
            existingData.setEmail(updatedData.getEmail());
            personRepo.save(existingData);

        }else{
            return null;
        }
        return existingData;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteData(@PathVariable Long id) {
        personRepo.deleteById(id);
    }
}
