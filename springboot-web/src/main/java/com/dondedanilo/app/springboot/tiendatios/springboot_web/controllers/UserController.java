package com.dondedanilo.app.springboot.tiendatios.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.User;
@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Map<String,Object> model){
        
        User useri = new User("Andres","Duran");


        model.put("tittle","Hola Mundo Con Spring");
        model.put("user",useri);
        model.put("profesion", "Panadero");
        model.put("number", "1234564789");
        model.put("email", "DonDimadon@Dimsdeel");
        return "details";
    }
    @GetMapping("/list")
    public String list(ModelMap modelMap){

       

        modelMap.addAttribute("title","Listado de usuarios");
        return "list";


    }
    @ModelAttribute("users")
    public List<User> usersModel(){
    return Arrays.asList(
        new User("Pepa", "Gonzales"),
        new User("Armando", "Casas"),
        new User("Chupame", "El Penco","laloCorrea@gmail.com"),
        new User("Andres","Duran","laloCarrea@gmail.com"));
    }
}
