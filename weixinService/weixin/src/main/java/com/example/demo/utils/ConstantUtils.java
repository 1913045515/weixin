package com.example.demo.utils;

/**
 * Created by qiang on 2018/1/1.
 */
public class ConstantUtils {
    //小程序appid
    public static final String appId="wx597151a7ab053b10";
    //微信支付的商户id
    public static final String mchId="1465105202";
    //小程序密钥
    public static final String secret="bddb25b94eccb3666e7f29981b67d720";
    //code 换取 session_key中类别
    public static final String grantType="authorization_code";
    //支付成功后的服务器回调url
    public static final String notifyUrl="https:www.wolzq.com/weixin/API/Order/notify";
    //微信支付的商户密钥
    public static final String key="xinshijie123456789XINSHIJIE12345";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String tradeType="JSAPI";
    //签名方式，固定值
    public static final String signType="MD5";
    //统一订单接口url地址
    public static final String createOrderUrl="https://api.mch.weixin.qq.com/pay/unifiedorder";
    //获取session_key和open_id的url地址
    public static final String getSessionKeyUrl="https://api.weixin.qq.com/sns/jscode2session";

}
