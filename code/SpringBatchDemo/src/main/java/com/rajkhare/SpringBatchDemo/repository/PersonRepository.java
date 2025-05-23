package com.rajkhare.SpringBatchDemo.repository;

import com.rajkhare.SpringBatchDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
