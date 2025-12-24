/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import com.enumerators.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author PC
 */
public class SaleDTO {
   
    private Integer idSale;
    private Integer clientId;
    private String clientName;
    private Integer userId;
    private String userName;
    private LocalDateTime saleDate;
    private BigDecimal totalSale;
    private BigDecimal amountPaid;
    private PaymentStatus paymentStatus;
    private List<SaleDetailDTO> details; 

    public SaleDTO() {
    }

    public SaleDTO(Integer idSale, Integer clientId, String clientName, Integer userId, String userName, LocalDateTime saleDate, BigDecimal totalSale, BigDecimal amountPaid, PaymentStatus paymentStatus, List<SaleDetailDTO> details) {
        this.idSale = idSale;
        this.clientId = clientId;
        this.clientName = clientName;
        this.userId = userId;
        this.userName = userName;
        this.saleDate = saleDate;
        this.totalSale = totalSale;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
        this.details = details;
    }

    public SaleDTO(Integer clientId, String clientName, Integer userId, String userName, LocalDateTime saleDate, BigDecimal totalSale, BigDecimal amountPaid, PaymentStatus paymentStatus, List<SaleDetailDTO> details) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.userId = userId;
        this.userName = userName;
        this.saleDate = saleDate;
        this.totalSale = totalSale;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
        this.details = details;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public BigDecimal getTotalSale() {
        return totalSale;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public List<SaleDetailDTO> getDetails() {
        return details;
    }
    
    

}
