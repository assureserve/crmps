package com.crmps.controller;

import com.crmps.domain.Person;
import com.crmps.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class PersonApiController {

    public static final Logger logger = LoggerFactory.getLogger(PersonApiController.class);

    @Autowired
    private PersonService personService;

    private static Map<Integer, Person> personMap = new HashMap<>();
    static {
        personMap.put(0, getPerson("john@test.com", "John", "Doe", "john123"));
        personMap.put(1, getPerson("2", "Jane", "Doe", "1234M"));
        personMap.put(2, getPerson("3", "Kevin", "Smith", "1234X"));
    }

    @CrossOrigin
    @RequestMapping("/hello")
    public @ResponseBody Person hello() {
        return new Person();
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    List<Person> sayHello() {
        List<Person> personList = Arrays.asList(
                personMap.get(1), personMap.get(2), personMap.get(3));
        return personList;
    }

    @CrossOrigin
    @RequestMapping(value = "/persons/{id}", method= RequestMethod.GET)
    public @ResponseBody
    Person getPerson(@PathVariable(value="id") String id) {
        return personMap.get(Integer.valueOf(id));
    }

//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public List<Person> getPerson() {
//        List<Person> persons = personService.findAllUsers();
//        if (persons.isEmpty()) {
//            return new ArrayList<>();
//        }
//        return persons;
//    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public List<Person> listAllUsers() {
        List<Person> persons = personService.findAllUsers();
        if (persons.isEmpty()) {
            return new ArrayList<>();
        }
        return persons;
    }

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody @Valid final Person person) {
        System.out.println("Received register....");
        personMap.put(personMap.size(), person);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Person loginUser(@RequestBody @Valid final Person person) {
        System.out.println("Received login....");
        for(Person p : personMap.values()) {
            if (p.getEmail().equals(person.getEmail()) && p.getPassword().equals(person.getPassword())) {
                return p;
            }
        }
//        Person p = personMap
//                .entrySet()
//                .stream()
//                .filter(personMap -> (person.getEmail().equals(personMap.getValue().getEmail())
//                        && person.getPassword().equals(personMap.getValue().getPassword())))
//                .map(personMap -> personMap.getValue())
//                .collect(Collectors.joining());
        //personMap.put(personMap.size(), person);
        return null;
    }

    private static Person getPerson(String email, String firstName, String lastName, String password) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPassword(password);
        System.out.println(person);
        return person;
    }
}
