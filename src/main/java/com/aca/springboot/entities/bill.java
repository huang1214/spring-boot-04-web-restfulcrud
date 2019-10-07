package com.aca.springboot.entities;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.xml.internal.bind.v2.TODO;
import oracle.sql.BLOB;

import java.util.Date;

//备案表对象
public class bill {

    @JSONField(ordinal = 1)
    private String bid;

    @JSONField(ordinal = 2)
    private String ctid;

    @JSONField(ordinal = 3)
    private Date cyear;

    @JSONField(ordinal = 4)
    private String clevel;  // 竞赛级别（国赛or省赛）

    @JSONField(ordinal = 5)
    private String cdesc;   // 竞赛描述

    @JSONField(ordinal = 6)
    private String groupleader;     // 负责人

    @JSONField(ordinal = 7)
    private String groupname;   // 团队名

    @JSONField(ordinal = 8)
    private String team;    // 团队成员信息表

    @JSONField(ordinal = 9)
    private String teacher1;    //指导老师1

    @JSONField(ordinal = 10)
    private String techaer2;    //指导老师2

    @JSONField(ordinal = 11)
    private String result;      // 成果类型

    @JSONField(ordinal = 12)
    private String workname;    // 作品名称

    @JSONField(ordinal = 13)
    private String preditfeedesc;   // 预算描述

    @JSONField(ordinal = 14)
    private double predictfee;   // 预算金额

    @JSONField(ordinal = 15)
    private String state;   // 申请状态

    @JSONField(ordinal = 16)
    private BLOB images;    // 一系列照片
}
