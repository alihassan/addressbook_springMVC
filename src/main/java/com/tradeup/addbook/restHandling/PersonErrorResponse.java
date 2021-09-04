package com.tradeup.addbook.restHandling;

//Custom error response class
public class PersonErrorResponse {
    private int status;
    private String msg;
    private long time;

    public PersonErrorResponse(){

    }

    public PersonErrorResponse(int status, String msg, long time) {
        this.status = status;
        this.msg = msg;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}