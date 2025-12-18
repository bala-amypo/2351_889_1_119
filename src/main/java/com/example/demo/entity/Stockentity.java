package com.example.demo.entity;

public class Stockentity{
    @Id
    private int id;
    @
    private String ticker;
    private String companyname;
    private String sector;
    private boolean active;

    public Stockentity(int id, String ticker, String companyname, String sector, boolean active) {
        this.id = id;
        this.ticker = ticker;
        this.companyname = companyname;
        this.sector = sector;
        this.active = active;
    }
    public Stockentity() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
