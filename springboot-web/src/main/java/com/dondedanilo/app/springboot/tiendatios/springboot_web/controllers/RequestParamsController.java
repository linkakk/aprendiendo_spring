    package com.dondedanilo.app.springboot.tiendatios.springboot_web.controllers;

    import com.dondedanilo.app.springboot.tiendatios.springboot_web.models.dto.ParamsDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/api/params")
    public class RequestParamsController {
        @GetMapping("/foo")
        public ParamsDto foo (@RequestParam(required = false,defaultValue = "debes pasar un parametro por eso estoy aqui") String message){

            ParamsDto paramsDto = new ParamsDto();
            paramsDto.setMessage(message);
            return paramsDto;
        }
        
    @GetMapping("/bar")
    public ParamsDto bar(@RequestParam String text,@RequestParam Integer code){


        ParamsDto paramsDto = new ParamsDto();
        paramsDto.setMessage(text);
        paramsDto.setCode(code);
        return paramsDto;
    }
    @GetMapping("/request")
    public ParamsDto request(HttpServletRequest request){
        Integer code = 10;
        try {
            code = Integer.parseInt(request.getParameter("code"));

        } catch (NumberFormatException e) {
        
        }
        ParamsDto paramsDto = new ParamsDto();
        paramsDto.setCode(code);
        paramsDto.setMessage(request.getParameter("message"));
        return paramsDto;

    }
    }
