package hr01.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalInfoConfig {

    @ModelAttribute(value = "authorInfo")
    Map<String,String> authorInfoConfig(){
        Map<String,String> map=new HashMap<>();
        map.put("name","pengzhuorong");
        map.put("address","shenzhen city,china");
        return map;
    }
}
