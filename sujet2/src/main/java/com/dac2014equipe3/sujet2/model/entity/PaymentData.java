/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;

/**
 *
 * @author Jummartinezro
 */
public class PaymentData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer paymentDataID;
    private String paypalAuthorization;
    private String creditcard;

    public PaymentData() {
    }

    public PaymentData(Integer paymentDataID) {
        this.paymentDataID = paymentDataID;
    }

    public Integer getPaymentDataID() {
        return paymentDataID;
    }

    public void setPaymentDataID(Integer paymentDataID) {
        this.paymentDataID = paymentDataID;
    }

    public String getPaypalAuthorization() {
        return paypalAuthorization;
    }

    public void setPaypalAuthorization(String paypalAuthorization) {
        this.paypalAuthorization = paypalAuthorization;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDataID != null ? paymentDataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentData)) {
            return false;
        }
        PaymentData other = (PaymentData) object;
        if ((this.paymentDataID == null && other.paymentDataID != null) || (this.paymentDataID != null && !this.paymentDataID.equals(other.paymentDataID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.PaymentData[ paymentDataID=" + paymentDataID + " ]";
    }

}
