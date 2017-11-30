package com.liferay.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class MonitorController {

    public MonitorController() {

    }

    public static void main(String[] args) {
        SpringApplication.run(MonitorController.class, args);
    }

    @RequestMapping("/")
    public ModelAndView hello() {
        return new ModelAndView("layout");
    }

}