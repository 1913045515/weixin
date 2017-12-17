package com.example.demo.vo;
public class OAuthJsToken {
    private String openid;              //用户唯一标识
    private int expires_in = 7200;      //凭证有效时间，单位：秒
    private String session_key;         //会话密匙
    private long exprexpiredTime;           //过期时间

    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public int getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
        this.exprexpiredTime = System.currentTimeMillis() + expires_in * 1000;
    }
    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public long getExprexpiredTime() {
        return exprexpiredTime;
    }
    public void setExprexpiredTime(long exprexpiredTime) {
        this.exprexpiredTime = exprexpiredTime;
    }
    /**
     * 判断用户凭证是否过期
     *
     * @return 过期返回 true,否则返回false
     */
    public boolean isExprexpired() {
        return System.currentTimeMillis() >= this.exprexpiredTime;
    }
}