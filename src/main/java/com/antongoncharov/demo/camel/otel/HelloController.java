package com.antongoncharov.demo.camel.otel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author antongoncharov
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam String name) {
        return "Hi, " + name;
    }

}
