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
@RequestMapping("/Api/Payment/")
public class PaymentController {

    @RequestMapping("buyCart")
    @ResponseBody
    public String buyCart(String cart_id,String uid) {
        Map<String, Object>result=new HashMap<String,Object>();
        List<Map<String, Object>> vouList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= 1; i++) {
            Map<String, Object> vouMap = new HashMap<String, Object>();
            vouMap.put("vid",i);
            vouMap.put("amount",10+i);
            vouMap.put("full_money",20+i);
            vouList.add(vouMap);
        }
        result.put("vouList",vouList);
        result.put("addemt",0);
        result.put("price",100);
        Map<String, Object> addressMap = new HashMap<String, Object>();
        addressMap.put("name","马云");
        addressMap.put("tel","18093195876");
        addressMap.put("address_xq","浙江省杭州市");
        result.put("address",addressMap);
        List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
        String[] ImageArr=new String[]{
                "http://www.wolzq.com/my/g1.jpg",
                "http://www.wolzq.com/my/g2.jpg",
                "http://www.wolzq.com/my/g3.jpg",
                "http://www.wolzq.com/my/g4.jpg",
                "http://www.wolzq.com/my/g5.jpg",
                "http://www.wolzq.com/my/g6.jpg"
        };
        for (int i = 0; i <= 5; i++) {
            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("id",i);
            productMap.put("name", "商品" + i);
            productMap.put("photo_x",ImageArr[i]);
            productMap.put("price", 10+ i);
            productMap.put("num",i);
            productList.add(productMap);
        }
        result.put("productList",productList);
        result.put("remark","快点送过来");
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping(value="/payment")
    @ResponseBody
    public Map<String,Object> payment(String orderId,String userId,String nonceStr,String prepayId){
        System.out.println("您调用了支付接口了！！！");
        System.out.println("userId:"+userId+"   orderId:"+orderId);
        Map<String,Object>result=new HashMap<>();
        result.put("status","1");
//        Long timeStamp = System.currentTimeMillis() / 1000;
//        result.put("timeStamp",timeStamp);
//        result.put("nonceStr",nonceStr);
//        result.put("package","prepay_id=" + prepayId);
//        result.put("signType","MD5");
//        //拼接签名需要的参数
//        String stringSignTemp = "appId=" + ConstantUtils.appId+ "&nonceStr=" + nonceStr + "&package=prepay_id=" + prepayId+ "&signType=MD5&timeStamp=" + timeStamp;
//        //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
//        String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();
//        result.put("paySign",paySign);
        return result;
    }
}
