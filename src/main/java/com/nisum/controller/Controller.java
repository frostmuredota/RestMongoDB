package com.nisum.controller;

import com.nisum.dao.PersonDao;
import com.nisum.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by ramon on 20-01-16.
 */
@RestController
@RequestMapping("/persons")
public class Controller {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/mypersons" , method = GET)
    public List<Person> myPersons(){
        return personDao.findAll();
    }

    @RequestMapping(value="/insert" , method = POST)
    @ResponseBody
    public ResponseEntity< Person> createPerson(@RequestBody Person person){

        boolean personFound = personDao.exists(person.getId());


        if(personFound){
            return new ResponseEntity<Person>(NOT_ACCEPTABLE);
        }else{
            personDao.save(person);
            return new ResponseEntity<Person>(person,OK);
        }

    }

    @RequestMapping(value="/delete/{id}" , method = DELETE)
    public ResponseEntity< Person> deletePerson(@PathVariable("id") int id ){

        boolean personFound = personDao.exists(id);


        if(personFound){
            Person aux = personDao.findOne(id);
            personDao.delete(id);
            return new ResponseEntity<Person>(aux,OK);
        }else{
            return new ResponseEntity<Person>(NOT_FOUND);
        }

    }

    @RequestMapping(value="/update" , method = PUT)
    @ResponseBody
    public ResponseEntity< Person> updatePerson(@RequestBody Person person){

        Person personFound = personDao.findOne(person.getId());

        if(personFound!=null){
            personFound.setName(person.getName());
            personFound.setLastname(person.getLastname());
            personDao.save(personFound);
            return new ResponseEntity<Person>(personFound,OK);
        }else{
            return new ResponseEntity<Person>(NOT_FOUND);
        }

    }

}
