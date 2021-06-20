package com.antongoncharov.demo.camel.otel;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author antongoncharov
 */
@Controller
public class DispatchController {

    private final ProducerTemplate template;

    public DispatchController(
        ProducerTemplate template
    ) {
        this.template = template;
    }

    @GetMapping("/dispatch")
    @ResponseBody
    public String sayHello(@RequestParam String name) {
        Object obj = template.sendBody("direct:dispatcher", ExchangePattern.InOut, name);
        return obj.toString();
    }

}
