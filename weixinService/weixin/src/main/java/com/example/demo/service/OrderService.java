package com.example.demo.service;

import com.example.demo.utils.ConstantUtils;
import com.example.demo.utils.WXPayUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiang on 2018/1/1.
 */

@Component
public class OrderService {

    //提交订单到微信
    public String commitData(String openId){
        String nonceStr= WXPayUtil.generateUUID();
        String body="JSAPI支付测试";
        Map<String, String> packageParams = new HashMap<String ,String>();
        packageParams.put("appid", ConstantUtils.appId);
        packageParams.put("body",body);
        packageParams.put("mch_id", ConstantUtils.mchId);
        packageParams.put("nonce_str",nonceStr);
        packageParams.put("notify_url", ConstantUtils.notifyUrl);//支付成功后的回调地址
        packageParams.put("openid",openId+"");//支付方式
        packageParams.put("out_trade_no", "12345678");//商户订单号
        packageParams.put("sign_type", ConstantUtils.signType);
        packageParams.put("spbill_create_ip","127.0.0.1");
        packageParams.put("total_fee", "1");//支付金额，这边需要转成字符串类型，否则后面的签名会失败
        packageParams.put("trade_type", ConstantUtils.tradeType);//支付方式
        String sign="";
        try {
            sign= WXPayUtil.generateSignature(packageParams, ConstantUtils.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String formData = "<xml>";
        formData += "<appid>"+ ConstantUtils.appId+"</appid>"; //appid
        formData += "<body>" + body+ "</body>";
        formData += "<mch_id>"+ ConstantUtils.mchId+"</mch_id>"; //商户号
        formData += "<nonce_str>"+nonceStr+"</nonce_str>";
        formData += "<notify_url>"+ ConstantUtils.notifyUrl+"</notify_url>";
        formData += "<openid>"+openId+"</openid>";
        formData += "<out_trade_no>" + "12345678" + "</out_trade_no>";
        formData += "<sign_type>"+ ConstantUtils.signType+"</sign_type>";
        formData += "<spbill_create_ip>"+"127.0.0.1"+"</spbill_create_ip>";
        formData += "<total_fee>" + "1" + "</total_fee>";
        formData += "<trade_type>"+ ConstantUtils.tradeType+"</trade_type>";
        formData += "<sign>"+sign+"</sign>";
        formData += "</xml>";
        return formData;
    }
}
