/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exampleredis.demoredis.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author mulyadi
 */
@RedisHash("master_accounts")
public class MasterAccounts implements Serializable{

    @Id
    String bic;
    double balance;
    double balanceHolder;
    double dbAmount;
    double crAmount;
    int dbTrx;
    int crTrx;

    public MasterAccounts(String bic, double balance, double balanceHolder, double dbAmount, double crAmount, int dbTrx, int crTrx) {
        this.bic = bic;
        this.balance = balance;
        this.balanceHolder = balanceHolder;
        this.dbAmount = dbAmount;
        this.crAmount = crAmount;
        this.dbTrx = dbTrx;
        this.crTrx = crTrx;
    }
    
    
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalanceHolder() {
        return balanceHolder;
    }

    public void setBalanceHolder(double balanceHolder) {
        this.balanceHolder = balanceHolder;
    }

    public double getDbAmount() {
        return dbAmount;
    }

    public void setDbAmount(double dbAmount) {
        this.dbAmount = dbAmount;
    }

    public double getCrAmount() {
        return crAmount;
    }

    public void setCrAmount(double crAmount) {
        this.crAmount = crAmount;
    }

    public int getDbTrx() {
        return dbTrx;
    }

    public void setDbTrx(int dbTrx) {
        this.dbTrx = dbTrx;
    }

    public int getCrTrx() {
        return crTrx;
    }

    public void setCrTrx(int crTrx) {
        this.crTrx = crTrx;
    }


    

}
