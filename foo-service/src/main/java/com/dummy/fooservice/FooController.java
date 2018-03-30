package com.dummy.fooservice;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@RestController
public class FooController {
    @RequestMapping("/persons")
    public List<Person> getPersons(){
    return getDummyUsers();
    }

    public List<Person> getDummyUsers (){
        return Arrays.asList(new Person(1235, "John", "Doe"),
                new Person(1239, "jane", "Doe"),
                new Person(1243, "Joe", "Doe"),
                new Person(1265, "jean", "Doe"));
    }
}
