package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.WxPayConfig;
import com.example.demo.service.OrderService;
import com.example.demo.utils.ConstantUtils;
import com.example.demo.utils.HttpUtils;
import com.example.demo.utils.PayUtil;
import com.example.demo.utils.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by qiang on 2017/12/10.
 */

@Controller
@RequestMapping("/Api/Order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

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

    @RequestMapping(value="/createOrder")
    @ResponseBody
    public Map<String,Object> createOrder(String openId){
        Map<String,Object>result=new HashMap<>();
        result.put("status","1");
        result.put("payType","weixin");
        result.put("orderId","12345678");
        String formData=orderService.commitData(openId);
        String httpResult = HttpUtils.httpXMLPost(ConstantUtils.createOrderUrl,formData);
        try {
            Map<String, String> resultMap = WXPayUtil.xmlToMap(httpResult);
            result.put("package", "prepay_id=" + resultMap.get("prepay_id"));
            result.put("nonceStr",resultMap.get("nonce_str"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String times= WXPayUtil.getCurrentTimestamp()+"";
        result.put("timeStamp",times);
        Map<String, String> packageParams = new HashMap<String ,String>();
        packageParams.put("appId", ConstantUtils.appId);
        packageParams.put("signType", ConstantUtils.signType);
        packageParams.put("nonceStr",result.get("nonceStr")+"");
        packageParams.put("timeStamp",times);
        packageParams.put("package", result.get("package")+"");//商户订单号
        String sign="";
        try {
            sign= WXPayUtil.generateSignature(packageParams, ConstantUtils.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("paySign",sign);
        return result;
    }



    /**
     * @Description:微信支付
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/notify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);
        Map map = WXPayUtil.xmlToMap(notityXml);
        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), WxPayConfig.key, "utf-8")){
                /**此处添加自己的业务逻辑代码start**/
                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");
        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }
}
