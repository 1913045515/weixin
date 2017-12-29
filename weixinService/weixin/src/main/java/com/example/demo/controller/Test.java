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
 * Created by lzq on 2017/12/29.
 */

@Controller
public class Test {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
      return "我是数据测试的。。。。。，如果看到就说明自动部署成功了！！！";
    }
}
