package com.nisum.dao;

import com.nisum.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ramon on 20-01-16.
 */
@Service
public interface PersonDao extends MongoRepository<Person,Integer> {
}
