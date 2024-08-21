package com.dondedanilo.app.springboot.tiendatios.springboot_web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.User;
import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String,Object> details(){
        User useri = new User("Andres","Duran");
       /* */ 
        Map<String, Object> body = new HashMap<>();


        body.put("tittle","Hola Mundo Con S");
        body.put("name",useri);
        body.put("profesion", "Panadero");
        body.put("number", "1234564789");

        return body;
 
    }

    @GetMapping("/detaills")
    public UserDto detailUserDto(){
        User useri = new User("Andres","Duran");
        UserDto userDto = new UserDto();
        userDto.setUser(useri);
        userDto.setTitle("Hola Mundo Con Spring Boot");
       /* 
        Map<String, Object> body = new HashMap<>();


        body.put("tittle","Hola Mundo Con S");
        body.put("name",useri);
        body.put("profesion", "Panadero");
        body.put("number", "1234564789");
*/ 
        return userDto;
    }
    @GetMapping("/details-map")
    public Map<String,Object> detailsMap(){
        User useri = new User("Andres","Duran");
       /* */ 
        Map<String, Object> body = new HashMap<>();


        body.put("tittle","Hola Mundo Con S");
        body.put("name",useri);
        body.put("profesion", "Panadero");
        body.put("number", "1234564789");

        return body;
    }

    //APIRESTLISTAR
    @GetMapping("/list")
    public List<User> list8(){
        User userA = new User("Andres", "Guzman");
        User userB = new User("Manzanillo", "DeAmor");
        User userC = new User("Suzana ", "Horia");

    
        List <User> users = Arrays.asList(userA,userB,userC);

        return users;

    }
}
