package com.creditcheck.repository;

import com.creditcheck.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("111-11-1111",true));
        personList.add(new Person("222-22-2222",false));
        personList.add(new Person("333-33-3333",true));
        personList.add(new Person("444-44-4444",false));
    }

    public List<Person> findAll(){
        return personList;
    }
    public Person findBySSN(String SSN)  {
        Optional<Person> personOptional = personList.stream().filter(person -> person.getSSN().equals(SSN)).findFirst();


        return personOptional.get();
    }
}
