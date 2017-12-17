package com.example.demo.vo;
public class ApiTicket extends BaseResponse{
    private String ticket;
    private long expires_in;

    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public long getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(long expires_in) {
        this.expires_in = System.currentTimeMillis() + (expires_in - 100) * 1000;//原expires_in是有效时长，比如：7200，现改为过期的时间戳
    }
}
