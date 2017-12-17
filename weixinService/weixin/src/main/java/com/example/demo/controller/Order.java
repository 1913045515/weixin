package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.WxPayConfig;
import com.example.demo.utils.PayUtil;
import com.example.demo.vo.AccessToken;
import com.example.demo.vo.OAuthJsToken;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foxinmy.weixin4j.exception.WeixinException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by qiang on 2017/12/10.
 */

@Controller
@RequestMapping("/Api/Order/")
public class Order {
    @RequestMapping("getOrder")
    @ResponseBody
    public String getOrder(String userId) {
        Map<String, Object>result=new HashMap<String,Object>();
        result.put("status","1");
        Map<String, Object> orderInfo = new HashMap<String, Object>();
        orderInfo.put("pay_num","1");
        orderInfo.put("rec_num", "2");
        orderInfo.put("refund_num","1");
        orderInfo.put("finish_num","3");
        result.put("orderInfo",orderInfo);
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }
}
