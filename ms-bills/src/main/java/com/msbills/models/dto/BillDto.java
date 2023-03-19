package com.msbills.models.dto;

import java.time.LocalDate;

public class BillDto {
    private String idBill;
    private LocalDate billingDate;
    private Double totalPrice;
    private UserDto user;


    public BillDto(String idBill, LocalDate billingDate, Double totalPrice, UserDto user) {
        this.idBill= idBill;
        this.billingDate= billingDate;
        this.totalPrice= totalPrice;
        this.user= user;
    }

    public BillDto(LocalDate billingDate, Double totalPrice, UserDto user) {
        this.billingDate= billingDate;
        this.totalPrice= totalPrice;
        this.user= user;
    }

    public BillDto() {
        //No-args constructor
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
