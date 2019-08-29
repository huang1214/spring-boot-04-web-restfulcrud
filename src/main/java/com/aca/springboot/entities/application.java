package com.aca.springboot.entities;


public class application {

    //application实体类属性
    private String app_id;
    private String competition_name;
    private String work_name;
    private String leader_id;
    private String unit;
    private String teacher_id;
    private String card_num;
    private String date_year;
    private String award_id;

    public application(String app_id, String competition_name, String work_name, String leader_id, String unit, String teacher_id, String card_num, String date_year, String award_id) {
        this.app_id = app_id;
        this.competition_name = competition_name;
        this.work_name = work_name;
        this.leader_id = leader_id;
        this.unit = unit;
        this.teacher_id = teacher_id;
        this.card_num = card_num;
        this.date_year = date_year;
        this.award_id = award_id;
    }

    public application(){

    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(String leader_id) {
        this.leader_id = leader_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getDate_year() {
        return date_year;
    }

    public void setDate_year(String date_year) {
        this.date_year = date_year;
    }

    public String getAward_id() {
        return award_id;
    }

    public void setAward_id(String award_id) {
        this.award_id = award_id;
    }

    @Override
    public String toString() {
        return "application{" +
                "app_id='" + app_id + '\'' +
                ", competition_name='" + competition_name + '\'' +
                ", work_name='" + work_name + '\'' +
                ", leader_id='" + leader_id + '\'' +
                ", unit='" + unit + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", card_num='" + card_num + '\'' +
                ", date_year='" + date_year + '\'' +
                ", award_id='" + award_id + '\'' +
                '}';
    }
}
