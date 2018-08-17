package demo.controller;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public String test(){
        return "TestSuccess";
    }

    //@PropertySource(value = {"classpath:application.properties","ddd"})
    @Value("${name}")
    private String name;
    @RequestMapping(value = "/showName",method = RequestMethod.GET)
    public String showName(){
        return name;
    }




}
