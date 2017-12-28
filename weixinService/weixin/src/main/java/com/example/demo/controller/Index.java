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
@RequestMapping("/Api/Product/")
public class Index {
    @RequestMapping("lists")
    @ResponseBody
    public String lists() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
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
            int index=random.nextInt(6);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id" + i);
            map.put("name", "手机" + i);
            map.put("photo_x",ImageArr[index]);
            map.put("price", 10+i);
            map.put("price_yh", 20+ i);
            map.put("shiyong",10+i);
            map.put("intro",i);
            list.add(map);
        }
        String jsonString = JSON.toJSONString(list);
        return jsonString;
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(String pro_id) {
        Map<String, Object> result=new HashMap<String,Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
            "http://www.wolzq.com/my/1.jpg",
            "http://www.wolzq.com/my/2.jpg",
            "http://www.wolzq.com/my/3.jpg"
        };
        Map<String, Object> proMap = new HashMap<String, Object>();
        proMap.put("photo_x", "http://www.wolzq.com/my/g1.jpg");
//        proMap.put("photo_d", "10");
        proMap.put("name", "iphone6s");
        proMap.put("cat_name", "苹果手机");
//        proMap.put("photo_string", "http://www.wolzq.com/my/g1.jpg");
        proMap.put("img_arr",ImageArr);
        proMap.put("pro_number", "100001");
        proMap.put("brand","苹果");
        proMap.put("price_yh","6000");
        proMap.put("num","100");
        proMap.put("id","1");

        String[] imgUrls=new String[]{
                "https://www.wolzq.com/my/g1.jpg",
                "https://www.wolzq.com/my/g2.jpg",
                "https://www.wolzq.com/my/g3.jpg",
                "https://www.wolzq.com/my/g4.jpg",
                "https://www.wolzq.com/my/g5.jpg",
                "https://www.wolzq.com/my/g6.jpg"
        };

        String imgUrl="<img src=\"https://www.wolzq.com/my/g6.jpg\" alt=\"\" width=\"100%\"/>"+
                "<img src=\"https://www.wolzq.com/my/g1.jpg\" alt=\"\" width=\"100%\" />"+
                "<img src=\"https://www.wolzq.com/my/g2.jpg\" alt=\"\" width=\"100%\" />"+
                "<img src=\"https://www.wolzq.com/my/g3.jpg\" alt=\"\" width=\"100%\" />"+
                "<img src=\"https://www.wolzq.com/my/g4.jpg\" alt=\"\" width=\"100%\" />"+
                "<img src=\"https://www.wolzq.com/my/g5.jpg\" alt=\"\" width=\"100%\" />";
        proMap.put("content",imgUrl);

        result.put("status","1");
        result.put("pro",proMap);
        result.put("err","执行成功");
        result.put("commodityAttr","");
        result.put("attrValueList","");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }


    @RequestMapping("index")
    @ResponseBody
    public String index() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
                "https://www.wolzq.com/my/1.jpg",
                "https://www.wolzq.com/my/2.jpg",
                "https://www.wolzq.com/my/3.jpg"
        };
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id_"+i );
            map.put("unique", "unique_" +i);
            map.put("photo", ImageArr[i]);
            list.add(map);
        }
        String jsonString = JSON.toJSONString(list);
        return jsonString;
    }
}
