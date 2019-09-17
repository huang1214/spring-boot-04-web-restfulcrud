package com.aca.springboot.entities;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class json {

    @JSONField(ordinal = 1)
    private int code;

    @JSONField(ordinal = 2)
    private String msg;

    @JSONField(ordinal = 3)
    private int count;

    @JSONField(ordinal = 4)
    private JSONArray data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "json{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data='" + data + '\'' +
                '}';
    }
}
