package dev.cnn.developer_horoscope.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fortune")
public class FortuneController {

    @GetMapping("/testing")
    public  String getFortune() {
        return "Today is a good day ";
    }


}
