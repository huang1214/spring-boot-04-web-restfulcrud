package com.aca.springboot.entities;

public class competition {
    private String ctid;
    private String ctname;
    private String host_unit;
    private String com_type;
    private String reference_paper;

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getHost_unit() {
        return host_unit;
    }

    public void setHost_unit(String host_unit) {
        this.host_unit = host_unit;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }

    public String getReference_paper() {
        return reference_paper;
    }

    public void setReference_paper(String reference_paper) {
        this.reference_paper = reference_paper;
    }
}
