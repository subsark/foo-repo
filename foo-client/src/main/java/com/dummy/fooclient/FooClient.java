package com.dummy.fooclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("foo-service")
public interface FooClient {

    @RequestMapping(value="/persons", method = RequestMethod.GET)
    List<Person> getPersons();

}
