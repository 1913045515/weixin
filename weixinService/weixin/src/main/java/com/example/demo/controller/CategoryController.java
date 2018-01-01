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
@RequestMapping("/Api/Category/")
public class CategoryController {
    @RequestMapping("index")
    @ResponseBody
    public String index() {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",i);
            map.put("name", "分类" + i);
            list.add(map);
        }
        result.put("list",list);
        List<Map<String, Object>> catList = new ArrayList<Map<String, Object>>();
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
            map.put("id",i);
            map.put("name", "分类" + i);
            map.put("bz_1",ImageArr[i]);
            catList.add(map);
        }
        result.put("catList",catList);
        result.put("err","执行成功");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("getCat")
    @ResponseBody
    public String getCat(String id) {
        Map<String, Object>result=new HashMap<String,Object>();
        List<Map<String, Object>> catList = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
                "http://www.wolzq.com/my/g1.jpg",
                "http://www.wolzq.com/my/g2.jpg",
                "http://www.wolzq.com/my/g3.jpg",
                "http://www.wolzq.com/my/g4.jpg",
                "http://www.wolzq.com/my/g5.jpg",
                "http://www.wolzq.com/my/g6.jpg"
        };
        Random random=new Random();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",i);
            map.put("name", "分类" + i);
            int index=random.nextInt(6);
            map.put("bz_1",ImageArr[index]);
            catList.add(map);
        }
        result.put("status","1");
        result.put("catList",catList);
        result.put("err","执行成功");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }
}
