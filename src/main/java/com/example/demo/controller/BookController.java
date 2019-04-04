package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
    public List<String> getBooksByPublisher(@PathVariable("id") Long id) {
        List<String> ss = new ArrayList<String>();
        ss.add("test01");
        return ss;
    }

}
