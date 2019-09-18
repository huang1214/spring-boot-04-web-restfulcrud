package com.aca.springboot.entities;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

public class test {

    @JSONField(ordinal = 1)
    private String dno;

    @JSONField(ordinal = 2)
    private String dname;

    @JSONField(ordinal = 3)
    private String dadmin;

    @JSONField(ordinal = 4)
    private String dtel;

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDadmin() {
        return dadmin;
    }

    public void setDadmin(String dadmin) {
        this.dadmin = dadmin;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    @Override
    public String toString() {
        return "test{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dadmin='" + dadmin + '\'' +
                ", dtel='" + dtel + '\'' +
                '}';
    }
}
