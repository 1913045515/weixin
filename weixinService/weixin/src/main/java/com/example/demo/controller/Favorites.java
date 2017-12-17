package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiang on 2017/12/10.
 */

@Controller
@RequestMapping("/Api/Favorites/")
public class Favorites {

    @RequestMapping("addFavorites")
    @ResponseBody
    public String addFavorites(String uid,String pid) {
        Map<String, Object> result = new HashMap<>();
        result.put("status","1");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }
}
