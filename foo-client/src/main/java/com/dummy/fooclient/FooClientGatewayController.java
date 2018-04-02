package com.dummy.fooclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FooClientGatewayController {

    @Autowired
    private FooClient fooClient;

    public List<Person> getFallbackPersons(){
        return new ArrayList<Person>();
    }

    @HystrixCommand(fallbackMethod = "getFallbackPersons")
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public List<Person> getPersons(){
        return fooClient.getPersons();
    }
    @RequestMapping("/foo/{uid}")
    public String getName(@PathVariable  int uid) {
        List<String> names =fooClient.getPersons().stream().
                filter(t -> t.getId() == uid).
                map(Person::getFname).
                collect(Collectors.toList());
        return CollectionUtils.isEmpty(names) ? "NEMO" : names.get(0);
    }
}
