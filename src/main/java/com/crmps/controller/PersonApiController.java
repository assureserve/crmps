package com.crmps.controller;

import com.crmps.domain.Person;
import com.crmps.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class PersonApiController {

    public static final Logger logger = LoggerFactory.getLogger(PersonApiController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    List<Person> sayHello() {
        List<Person> personList = Arrays.asList(
                getPerson("1", "John", "Doe", "1234L"),
                getPerson("2", "Jane", "Doe", "1234M"),
                getPerson("3", "John", "Smith", "1234X"));
        return personList;
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public List<Person> listAllUsers() {
        List<Person> persons = personService.findAllUsers();
        if (persons.isEmpty()) {
            return new ArrayList<>();
        }
        return persons;
    }

    private Person getPerson(String userId, String firstName, String lastName, String govermentId) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setGovermentId(govermentId);
        person.setUserId(userId);
        return person;
    }
}
