package com.dondedanilo.app.springboot.tiendatios.springboot_web.models.dto;

public class ParamsDto {
    private String message;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
