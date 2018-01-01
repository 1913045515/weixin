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
@RequestMapping("/Api/ProductList/")
public class ProductController {
    @RequestMapping("list")
    @ResponseBody
    public String list(String cat_id,String ptype,String brand_id) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
                "http://www.wolzq.com/my/g1.jpg",
                "http://www.wolzq.com/my/g2.jpg",
                "http://www.wolzq.com/my/g3.jpg",
                "http://www.wolzq.com/my/g4.jpg",
                "http://www.wolzq.com/my/g5.jpg",
                "http://www.wolzq.com/my/g6.jpg"
        };
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id" + i);
            map.put("name", "手机" + i);
            map.put("photo_x",ImageArr[i]);
            map.put("price", 10+i);
            map.put("price_yh", 20+ i);
            map.put("shiyong",10+i);
            map.put("intro",i);
            list.add(map);
        }
        result.put("pro",list);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }
}
