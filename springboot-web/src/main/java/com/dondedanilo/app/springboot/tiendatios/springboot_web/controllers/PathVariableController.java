package com.dondedanilo.app.springboot.tiendatios.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.User;
import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.dto.ParamsDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valueMap;

    @Value("#{${config.valuesMap}.product}")
    private String productMap;
    
    @Value("#{${config.valuesMap}.price}")
    private Long priceMap;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.userName}")
    private String userName;

    @Value("${config.message}")
    private  String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.otroMensaje}")
    private String otroMensaje;

    @Autowired
    private Environment environment;
    @GetMapping("/baz/{message}")
    public ParamsDto baz(@PathVariable(name = "message") String otroMensaje){

        ParamsDto paramsDto = new ParamsDto();

        paramsDto.setMessage(otroMensaje);
        return paramsDto;

}

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
        
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("id", id);
        jsonMap.put("product", product);

        return jsonMap;
    }

@PostMapping("/create")
public User creaUser (@RequestBody User user){
    //vamos a convertir el usuario a mayuscula
    user.setName(user.getName().toUpperCase());
    return user;

}

//llamar las configuraciones almacenadas en properties
@GetMapping("/values")
public Map<String, Object> values(){

    Map<String,Object> json = new HashMap<>();

    json.put("messageDesdeEnviremont", environment.getProperty("config.message"));
    json.put("codeDesdeEnviremont",environment.getProperty("config.code",String.class));
    json.put("userName", userName);
    json.put("code", code);
    json.put("listOfValues", listOfValues);
    json.put("message", message);
    json.put("otroMensaje", otroMensaje);
    json.put("valuesMap", valueMap);
    json.put("product", productMap);
    json.put("price", priceMap);

    return json;

}


}
