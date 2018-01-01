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
@RequestMapping("/Api/Address/")
public class AddressController {
    @RequestMapping("index")
    @ResponseBody
    public String index(String user_id) {
        Map<String, Object>result=new HashMap<String,Object>();
        List<Map<String, Object>> addressArray = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> addressMap = new HashMap<String, Object>();
            addressMap.put("id",i);
            addressMap.put("name", "张翔" + i);
            if(i==0){
                addressMap.put("is_default",1);
            }else{
                addressMap.put("is_default",0);
            }
            addressMap.put("tel","1809876453"+i);
            addressMap.put("address_xq","中国北京昭阳区"+i);
            addressArray.add(addressMap);
        }
        result.put("addressArray",addressArray);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("setDefault")
    @ResponseBody
    public String setDefault(String uid, String addr_id) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("deleteAddress")
    @ResponseBody
    public String deleteAddress(String uid, String addr_id) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("addAddress")
    @ResponseBody
    public String addAddress(String user_id, String receiver,String tel,
    String sheng,String city,String quyu,String adds,String code) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("getProvince")
    @ResponseBody
    public String getProvince(String uid, String addr_id) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        List<Map<String, Object>> provinceArray = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> provinceMap = new HashMap<String, Object>();
            provinceMap.put("id",i);
            provinceMap.put("name", "省份" + i);
            provinceArray.add(provinceMap);
        }
        result.put("provinceArray",provinceArray);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("getCity")
    @ResponseBody
    public String getCity(String sheng) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        List<Map<String, Object>> cityArray = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> cityMap = new HashMap<String, Object>();
            cityMap.put("id",i);
            cityMap.put("name", "城市" + i);
            cityArray.add(cityMap);
        }
        result.put("cityArray",cityArray);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("getArea")
    @ResponseBody
    public String getArea(String sheng,String city) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        List<Map<String, Object>> areaArray = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> areaMap = new HashMap<String, Object>();
            areaMap.put("id",i);
            areaMap.put("name", "地区" + i);
            areaArray.add(areaMap);
        }
        result.put("areaArray",areaArray);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String quyu, String city) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        result.put("area",1);
        result.put("code",1);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

}
