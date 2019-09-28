package com.aca.springboot.entities;

import com.alibaba.fastjson.annotation.JSONField;

public class teacher {

    @JSONField(ordinal = 1)
    private String tno;

    @JSONField(ordinal = 2)
    private String tname;

    @JSONField(ordinal = 3)
    private String tsex;

    @JSONField(ordinal = 4)
    private String tbirthday;

    @JSONField(ordinal = 5)
    private String dno;

    @JSONField(ordinal = 6)
    private String dname;

    @JSONField(ordinal = 7)
    private String dcollege;

    @JSONField(ordinal = 8)
    private String ttel;

    @JSONField(ordinal = 9)
    private String ttitle;

    @JSONField(ordinal = 10)
    private String tpwd;

    @JSONField(ordinal = 11)
    private String tstate;

    @JSONField(ordinal = 12)
    private String card_num;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(String tbirthday) {
        this.tbirthday = tbirthday;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getTstate() {
        return tstate;
    }

    public void setTstate(String tstate) {
        this.tstate = tstate;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcollege() {
        return dcollege;
    }

    public void setDcollege(String dcollege) {
        this.dcollege = dcollege;
    }
}
