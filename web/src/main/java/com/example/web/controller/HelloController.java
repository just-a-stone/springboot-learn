package com.example.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.web.service.ProviderService;
import com.example.web.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lupf on 2017/2/20.
 */
//@RestController
@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    @Reference
    private ProviderServiceImpl providerService;

    @ResponseBody
    @RequestMapping("say")
    public Object say() {
        Map map = new HashMap();
        map.put("aaa", "hello world!");

        return map;
    }

    @RequestMapping("thy")
    public String thy(Model model) {
        Map map = new HashMap();
        map.put("say", "hello world!");

        model.addAttribute("person", map);

        return "index";
    }

    @ResponseBody
    @RequestMapping("consume")
    public Object consume() {

        return providerService.hello();
    }
}
