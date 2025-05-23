package com.rajkhare.SpringBatchDemo.config;

import com.rajkhare.SpringBatchDemo.entity.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {

        person.setFirstName(person.getFirstName().toUpperCase());
        person.setLastName(person.getLastName().toUpperCase());
        person.setGender(person.getGender().equals("Male")?"M":"F");

        return person;
    }
}
