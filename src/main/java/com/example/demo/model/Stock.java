package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.*;
public class Stockentity{
    @Id
    private Long id;
    @column(unique=true)
    private String ticker;
    private String companyname;
    private String sector;
    private boolean active;

    public Stock(Long id, String ticker, String companyname, String sector, boolean active) {
        this.id = id;
        this.ticker = ticker;
        this.companyname = companyname;
        this.sector = sector;
        this.active = active;
    }
    public Stock() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
