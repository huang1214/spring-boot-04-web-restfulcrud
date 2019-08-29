package com.aca.springboot.entities;

public class work {
    private String app_id;
    private String competition_name;
    private String work_name;
    private String leader_id;
    private String teacher_id;
    private String date_year;
    private String student_price;
    private String teacher_price;
    private String is_check;

    public work(String app_id, String competition_name, String work_name, String leader_id, String teacher_id, String date_year, String student_price, String teacher_price, String is_check) {
        this.app_id = app_id;
        this.competition_name = competition_name;
        this.work_name = work_name;
        this.leader_id = leader_id;
        this.teacher_id = teacher_id;
        this.date_year = date_year;
        this.student_price = student_price;
        this.teacher_price = teacher_price;
        this.is_check = is_check;
    }

    public work() {
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

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getDate_year() {
        return date_year;
    }

    public void setDate_year(String date_year) {
        this.date_year = date_year;
    }

    public String getStudent_price() {
        return student_price;
    }

    public void setStudent_price(String student_price) {
        this.student_price = student_price;
    }

    public String getTeacher_price() {
        return teacher_price;
    }

    public void setTeacher_price(String teacher_price) {
        this.teacher_price = teacher_price;
    }

    public String getIs_check() {
        return is_check;
    }

    public void setIs_check(String is_check) {
        this.is_check = is_check;
    }
}
