package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by qiang on 2017/12/10.
 */

@Controller
@RequestMapping("/Api/Shopping/")
public class ShoppingController {
    @RequestMapping("index")
    @ResponseBody
    public String index(String user_id) {
        Map<String, Object>result=new HashMap<String,Object>();
        List<Map<String, Object>> cartList = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
                "http://www.wolzq.com/my/g1.jpg",
                "http://www.wolzq.com/my/g2.jpg",
                "http://www.wolzq.com/my/g3.jpg",
                "http://www.wolzq.com/my/g4.jpg",
                "http://www.wolzq.com/my/g5.jpg",
                "http://www.wolzq.com/my/g6.jpg"
        };
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> cartMap = new HashMap<String, Object>();
            cartMap.put("id",i);
            cartMap.put("pro_name", "商品" + i);
            cartMap.put("price",i);
            cartMap.put("num",i);
            cartMap.put("selected",true);
            cartMap.put("photo_x",ImageArr[i]);
            cartList.add(cartMap);
        }
        result.put("cart",cartList);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(String cart_id) {
        Map<String, Object> result=new HashMap<String,Object>();
        result.put("status",1);
        result.put("msg","删除成功！");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(String uid,String pid,String num) {
        Map<String, Object> result=new HashMap<String,Object>();
        result.put("status",1);
        result.put("msg","添加成功！");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("minus")
    @ResponseBody
    public String minus(String user_id,String num,String cart_id) {
        Map<String, Object> result=new HashMap<String,Object>();
        result.put("status",1);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("plus")
    @ResponseBody
    public String plus(String user_id,String num,String cart_id) {
        Map<String, Object> result=new HashMap<String,Object>();
        result.put("status",1);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }
}
