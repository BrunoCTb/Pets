<<<<<<< Updated upstream
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
=======
//package com.pets.petsecommerce;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//@Data
//class Address {
//    private Long id;
//    private String rua;
//    private String complemento;
//    private Long numero;
//    private String cidade;
//    private String estado;
//    private String cep;
//
//    public Address(Long id, String rua, String complemento, Long numero, String cidade, String estado) {
//        this.id = id;
//        this.rua = rua;
//        this.complemento = complemento;
//        this.numero = numero;
//        this.cidade = cidade;
//        this.estado = estado;
//    }
//}
//
//@AllArgsConstructor
//@Data
//class User {
//    private Long id;
//    private String email;
//    private String password;
//    private Address address;
//
//
//}
//
//public class Ot {
//
//    public static void main(String[] args) throws ParseException {
////        new Address(1, "rua dois", "mercado", 25L, "São Paulo", )
//
//        HashMap<String, String> address1 = new HashMap<>();
//
//
//        User user = new User(1, "user@gmail.com", "123");
//
//
//    }
//
//}
>>>>>>> Stashed changes
