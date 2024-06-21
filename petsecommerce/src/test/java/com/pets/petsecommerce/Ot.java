package com.pets.petsecommerce;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ot {

    public static void main(String[] args) throws ParseException {
        var date = "2004-05-22"; // yyyy-mm-dd
        var pattern = "yyyy-MM-dd";

        DateTimeFormatter newDate = DateTimeFormatter.ofPattern(pattern);

        System.out.println(newDate);

    }
}
