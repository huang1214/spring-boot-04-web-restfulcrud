package com.aca.springboot.entities;

public class award {
    //award实体属性
    private String atid;
    private String com_type;
    private String rtname;
    private String ltname;
    private String ptname;
    private String teacher_price;
    private String student_price;

    public String getAtid() {
        return atid;
    }

    public void setAtid(String atid) {
        this.atid = atid;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname;
    }

    public String getLtname() {
        return ltname;
    }

    public void setLtname(String ltname) {
        this.ltname = ltname;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    public String getTeacher_price() {
        return teacher_price;
    }

    public void setTeacher_price(String teacher_price) {
        this.teacher_price = teacher_price;
    }

    public String getStudent_price() {
        return student_price;
    }

    public void setStudent_price(String student_price) {
        this.student_price = student_price;
    }
}
