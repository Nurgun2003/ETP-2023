package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToWordController {
    private String[] words1 = {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen"
    };
    private String[] words2 = {
        "",
        "",
        "twenty",
        "thirty",
        "fourty",
        "fifty",
        "sixty",
        "seventy",
        "eighty",
        "ninety"
    };
	private final AtomicLong counter = new AtomicLong();

    @GetMapping("/numbertoword/{num}")
    public NumberToWord numbertoword(@PathVariable int num) {
        String s;
        num = num % 100;
        if(num < 20) {
            s = words1[num];
        } else {
            s = words2[num / 10];
            if(num % 10 > 0) {
                s += "-" + words1[num % 10];
            }
        }
        return new NumberToWord(counter.incrementAndGet(), s);
    }
}