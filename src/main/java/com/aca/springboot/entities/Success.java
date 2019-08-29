package com.aca.springboot.entities;

public class Success {
    private String app_id;
    private String leader_id;
    private String teacher_id;
    private String stu_price;
    private String tea_price;
    private String date_year;
    private String competition_id;
    private String is_check;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(String leader_id) {
        this.leader_id = leader_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStu_price() {
        return stu_price;
    }

    public void setStu_price(String stu_price) {
        this.stu_price = stu_price;
    }

    public String getTea_price() {
        return tea_price;
    }

    public void setTea_price(String tea_price) {
        this.tea_price = tea_price;
    }

    public String getDate_year() {
        return date_year;
    }

    public void setDate_year(String date_year) {
        this.date_year = date_year;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public String getIs_check() {
        return is_check;
    }

    public void setIs_check(String is_check) {
        this.is_check = is_check;
    }

    @Override
    public String toString() {
        return "Success{" +
                "app_id='" + app_id + '\'' +
                ", leader_id='" + leader_id + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", stu_price='" + stu_price + '\'' +
                ", tea_price='" + tea_price + '\'' +
                ", date_year='" + date_year + '\'' +
                ", competition_id='" + competition_id + '\'' +
                ", is_check='" + is_check + '\'' +
                '}';
    }
}
